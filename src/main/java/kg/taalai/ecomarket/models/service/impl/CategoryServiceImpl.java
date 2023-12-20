package kg.taalai.ecomarket.models.service.impl;

import kg.taalai.ecomarket.mappers.CategoryMapper;
import kg.taalai.ecomarket.models.dtos.CategoryDto;
import kg.taalai.ecomarket.models.entities.Category;
import kg.taalai.ecomarket.models.service.CategoryService;
import kg.taalai.ecomarket.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepo.findAll();

        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
