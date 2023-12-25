package kg.taalai.ecomarket.controller;

import kg.taalai.ecomarket.models.dtos.OrderDto;
import kg.taalai.ecomarket.models.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    OrderDto save(@Validated @RequestBody OrderDto orderDto){
        try{
            return orderService.save(orderDto);
        }catch (RuntimeException e){
            throw new RuntimeException("Invalid save product " + orderDto.getPhone());
        }
    }

    @GetMapping("/get/all/by/user")
    List<OrderDto> getAllByUser(@RequestParam Long id){
        try{
            return orderService.findByUser(id);
        }catch (RuntimeException e){
            throw new RuntimeException("Error retrieving data");
        }
    }
}

