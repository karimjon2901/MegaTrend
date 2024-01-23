package mt.megatrend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDto {
    private Double priceOfAllProducts;
    private Double profit;
    private Double balance;
    private LocalDateTime updatedAt;
}
