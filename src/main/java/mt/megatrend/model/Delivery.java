package mt.megatrend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    private String id;
    private String orderId;
    @OneToMany
    private List<Product> products;
    private short status;
    private Double price;
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdDate;
}