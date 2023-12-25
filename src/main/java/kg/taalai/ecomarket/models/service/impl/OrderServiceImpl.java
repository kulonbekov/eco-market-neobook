package kg.taalai.ecomarket.models.service.impl;

import kg.taalai.ecomarket.mappers.OrderMapper;
import kg.taalai.ecomarket.models.dtos.OrderDto;
import kg.taalai.ecomarket.models.dtos.ProductDto;
import kg.taalai.ecomarket.models.entities.Order;
import kg.taalai.ecomarket.models.entities.Product;
import kg.taalai.ecomarket.models.service.OrderService;
import kg.taalai.ecomarket.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrderRepo orderRepo;
    @Override
    public OrderDto save(OrderDto orderDto) {

        return orderMapper.toDto(orderRepo.save(orderMapper.toEntity(orderDto)));
    }

    @Override
    public List<OrderDto> findByUser(Long id) {
        List<Order> orders = orderRepo.findByUser_Id(id);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
