package kg.taalai.ecomarket.mappers;

import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.entities.Product;
import org.mapstruct.factory.Mappers;

public interface ProductMapper extends BaseMapper<Product, ProductDto> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
