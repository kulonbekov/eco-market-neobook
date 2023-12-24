package kg.taalai.ecomarket.models.service;

import kg.taalai.ecomarket.models.dtos.OrderDto;
import kg.taalai.ecomarket.models.entities.Order;

public interface OrderService {

    OrderDto save(OrderDto orderDto);
}
