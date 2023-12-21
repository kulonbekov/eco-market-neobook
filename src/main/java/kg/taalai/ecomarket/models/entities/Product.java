package kg.taalai.ecomarket.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_product")
@Builder
public class Product extends BaseEntity{

    @Column(unique = true)
    @NotNull
    String name;

    @Column(name = "cost")
    Double cost;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "description")
    String description;
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}
