package kg.taalai.ecomarket.controller;

import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/all")
    ResponseEntity<List<ProductDto>> findAllByProduct() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("get/all/by/category")
    ResponseEntity<List<ProductDto>> findProductsByCategory(@RequestParam Long categoryId){
        List<Long> CategoryIds = new ArrayList<>();
        CategoryIds.add(categoryId);
        return ResponseEntity.ok(productService.findProductsByCategory(CategoryIds));
    }

    @PostMapping("/save")
    ProductDto save(@Validated @RequestBody ProductDto productDto){
        try{
            return productService.save(productDto);
        }catch (RuntimeException e){
            throw new RuntimeException("Invalid save product " + productDto.getName());
        }
    }
}
