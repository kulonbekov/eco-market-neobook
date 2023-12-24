package kg.taalai.ecomarket.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.taalai.ecomarket.models.entities.User;
import kg.taalai.ecomarket.models.enums.Status;

import java.util.Date;

public class OrderDto {

    Long id;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;
    Status status;
    String orderNumber;
    String phone;
    String address;
    String referencePoint;
    String comment;
    User user;
}
