package kg.taalai.ecomarket.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity{

    @Column(unique = true)
    @NotNull
    String name;
    @Column(name = "image_url")
    String imageUrl;
}
