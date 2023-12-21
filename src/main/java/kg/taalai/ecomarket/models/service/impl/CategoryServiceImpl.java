package kg.taalai.ecomarket.models.service.impl;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import kg.taalai.ecomarket.mappers.CategoryMapper;
import kg.taalai.ecomarket.models.dtos.CategoryDto;
import kg.taalai.ecomarket.models.entities.Category;
import kg.taalai.ecomarket.models.service.CategoryService;
import kg.taalai.ecomarket.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;


    private List<Category> categories;

    @PostConstruct
    public void loadCategoryInDB() {
        Faker faker = new Faker();
        Set<String> uniqueCategoryNames = new HashSet<>();
        categories = new ArrayList<>();

        while (uniqueCategoryNames.size() < 10) {
            String categoryName = faker.commerce().department();
            if (uniqueCategoryNames.add(categoryName)) {
                Category category = Category.builder()
                        .name(categoryName)
                        .imageUrl(faker.company().url())
                        .build();
                categories.add(category);
            }
        }

        if (categoryRepo.findAll().isEmpty()) {
            categoryRepo.saveAll(categories);
        }
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepo.findAll();

        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
