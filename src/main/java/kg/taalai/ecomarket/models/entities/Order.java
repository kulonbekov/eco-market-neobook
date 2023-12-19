package kg.taalai.ecomarket.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_order")
public class Order extends BaseEntity{

    @Column(name = "address")
    String address;
    @Column(name = "reference_point")
    String referencePoint;
    @Column(name = "comment")
    String comment;
}
