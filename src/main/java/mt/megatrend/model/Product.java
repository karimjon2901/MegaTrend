package mt.megatrend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    @ManyToOne
    private Category category;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Double originalPrice;
    private Integer count;
    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdAt;
}
