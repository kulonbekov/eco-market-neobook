package kg.taalai.ecomarket.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import kg.taalai.ecomarket.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "created")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;

    @Column(name = "updated")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

    @PrePersist
    protected void onCreate() {
        created = new Date();
        updated = new Date();
        status = Status.ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }


}
