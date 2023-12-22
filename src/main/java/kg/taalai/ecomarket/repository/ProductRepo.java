package kg.taalai.ecomarket.repository;

import kg.taalai.ecomarket.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findDistinctByCategoriesIdIn(List<Long> ids);
}
