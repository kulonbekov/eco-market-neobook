package kg.taalai.ecomarket.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.taalai.ecomarket.models.enums.Status;

import java.util.Date;

public class ProductDto {

    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;
    Status status;
    String name;
    Double cost;
    String imageUrl;
    String description;
}
