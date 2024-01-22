package mt.megatrend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Double originalPrice;
    private String country;
    private List<Integer> size;
    private LocalDateTime createdAt;
}

