package kg.taalai.ecomarket.controller;

import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/all")
    ResponseEntity<List<ProductDto>> findAllByCategory() {
        return ResponseEntity.ok(productService.getAll());
    }
}
