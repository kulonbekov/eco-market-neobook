package kg.taalai.ecomarket.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.taalai.ecomarket.models.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    Set<Long> categoryIds;
}
