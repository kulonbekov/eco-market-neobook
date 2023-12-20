package kg.taalai.ecomarket.mappers;

import kg.taalai.ecomarket.models.dtos.CategoryDto;
import kg.taalai.ecomarket.models.entities.Category;
import org.mapstruct.factory.Mappers;

public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
