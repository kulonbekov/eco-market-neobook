package kg.taalai.ecomarket.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity{

    @Column(name="username", unique = true)
    @NotNull
    String username;
    @Column(name="email", unique = true)
    @NotNull
    String email;
    @Column(name="phone")
    String phone;
    @Column(name="password", unique = true)
    @NotNull
    String password;
    @OneToMany(mappedBy = "user")
    List<Order> orders;

}
