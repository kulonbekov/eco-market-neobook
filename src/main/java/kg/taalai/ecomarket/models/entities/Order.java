package kg.taalai.ecomarket.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_order")
@Builder
public class Order extends BaseEntity{

    static final AtomicLong counter = new AtomicLong(1);
    @Column(name = "order_number", nullable = false, unique = true, length = 8)
    String orderNumber;
    @Column(name = "phone")
    String phone;
    @Column(name = "address")
    String address;
    @Column(name = "reference_point")
    String referencePoint;
    @Column(name = "comment")
    String comment;
    @Column(name = "total_price")
    Double totalPrice;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    User user;
    @Override
    protected void onCreate() {
        this.orderNumber = String.format("%08d", counter.getAndIncrement());
        super.onCreate(); // Вызов родительского метода для сохранения общей логики
    }
}
