package kg.taalai.ecomarket.mappers;

import kg.taalai.ecomarket.models.dtos.OrderDto;
import kg.taalai.ecomarket.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
