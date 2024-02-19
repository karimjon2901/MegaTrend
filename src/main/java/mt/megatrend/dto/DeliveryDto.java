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
public class DeliveryDto {
    private String id;
    private String orderId;
    private List<ProductDto> products;
    private short status;
    private Double price;
    private LocalDateTime createdDate;
}
