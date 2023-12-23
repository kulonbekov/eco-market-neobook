package kg.taalai.ecomarket.repository;

import kg.taalai.ecomarket.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
