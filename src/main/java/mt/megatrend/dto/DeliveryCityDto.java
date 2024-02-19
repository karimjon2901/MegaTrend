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
public class DeliveryCityDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String keyword;
    private List<ProductDto> products;
    private short status;
    private LocalDateTime date;
    private LocalDateTime createdDate;
}
