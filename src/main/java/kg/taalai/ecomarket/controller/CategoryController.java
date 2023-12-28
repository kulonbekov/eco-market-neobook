package kg.taalai.ecomarket.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.taalai.ecomarket.models.dtos.CategoryDto;
import kg.taalai.ecomarket.models.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "1. Категория")
@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation("Получения всех категорий")
    @GetMapping("/get/all")
    ResponseEntity<List<CategoryDto>> findAllByCategory() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
