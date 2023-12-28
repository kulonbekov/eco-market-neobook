package kg.taalai.ecomarket.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "tb_category")
@Builder
public class Category extends BaseEntity{

    @Column(unique = true)
    @NotNull
    String name;
    @Column(name = "image_url")
    String imageUrl;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    Set<Product> products = new HashSet<>();
}
