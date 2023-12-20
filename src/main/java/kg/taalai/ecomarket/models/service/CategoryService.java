package kg.taalai.ecomarket.models.service;

import kg.taalai.ecomarket.models.dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();
}
