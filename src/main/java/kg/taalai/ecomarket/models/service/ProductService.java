package kg.taalai.ecomarket.models.service;

import kg.taalai.ecomarket.models.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();
    List<ProductDto> findProductsByCategory(List<Long> ids);
    ProductDto save(ProductDto productDto);
}
