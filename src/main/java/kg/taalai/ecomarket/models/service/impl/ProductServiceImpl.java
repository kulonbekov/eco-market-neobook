package kg.taalai.ecomarket.models.service.impl;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import kg.taalai.ecomarket.mappers.ProductMapper;
import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.entities.Category;
import kg.taalai.ecomarket.models.entities.Product;
import kg.taalai.ecomarket.models.service.ProductService;
import kg.taalai.ecomarket.repository.CategoryRepo;
import kg.taalai.ecomarket.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    ProductMapper productMapper = ProductMapper.INSTANCE;

    List<Product> products;

    @PostConstruct
    public void loadProductInDB() {
        Faker faker = new Faker();
        Set<String> uniqueProductNames = new HashSet<>();
        products = new ArrayList<>();

        // Получаем список всех категорий из репозитория
        List<Category> allCategories = categoryRepo.findAll();

        while (uniqueProductNames.size() < 10) {
            String productName = faker.commerce().productName();
            if (uniqueProductNames.add(productName)) {
                Product product = Product.builder()
                        .name(productName)
                        .cost(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.commerce().department())
                        .imageUrl(faker.company().url())
                        .categories(Collections.singleton(getRandomCategory(allCategories)))
                        .build();
                products.add(product);
            }
        }
        if (productRepo.findAll().isEmpty()) {
            productRepo.saveAll(products);
        }
    }

    private Category getRandomCategory(List<Category> categories) {
        // Генерируем случайный индекс из диапазона размера списка
        int randomIndex = new Random().nextInt(categories.size());
        return categories.get(randomIndex);
    }

    @Override
    public List<ProductDto> getAll() {

        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
