package kg.taalai.ecomarket.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "2. Продукты")
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiOperation("Получения всех товаров")
    @GetMapping("/get/all")
    ResponseEntity<List<ProductDto>> findAllByProduct() {
        return ResponseEntity.ok(productService.getAll());
    }

    @ApiOperation("Получения всех товаров по категориям")
    @GetMapping("get/all/by/category")
    ResponseEntity<List<ProductDto>> findProductsByCategory(@RequestParam Long categoryId){
        List<Long> CategoryIds = new ArrayList<>();
        CategoryIds.add(categoryId);
        return ResponseEntity.ok(productService.findProductsByCategory(CategoryIds));
    }
    @ApiOperation("Получения товара по ID")
    @GetMapping("get/by/{id}")
    ProductDto getById(@PathVariable Long id){
        try{
            return productService.findById(id);
        }catch (RuntimeException e){
            throw new RuntimeException("No product found for this " + id);
        }
    }

    @ApiOperation("Добавления нового товара")
    @PostMapping("/save")
    ProductDto save(@Validated @RequestBody ProductDto productDto){
        try{
            return productService.save(productDto);
        }catch (RuntimeException e){
            throw new RuntimeException("Invalid save product " + productDto.getName());
        }
    }
}
