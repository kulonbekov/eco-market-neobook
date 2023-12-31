package kg.taalai.ecomarket.repository;

import kg.taalai.ecomarket.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findByUser_Id(Long id);
}
