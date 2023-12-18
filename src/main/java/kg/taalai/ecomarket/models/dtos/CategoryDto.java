package kg.taalai.ecomarket.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.taalai.ecomarket.models.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDto {

    Long id;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;
    Status status;
    String name;
    String imageUrl;



}
