package kg.taalai.ecomarket.models.service;

import kg.taalai.ecomarket.models.dtos.OrderDto;
import kg.taalai.ecomarket.models.entities.Order;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderDto orderDto);
    List<OrderDto> findByUser (Long id);
    List<OrderDto> findAll();
}
