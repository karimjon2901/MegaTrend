package mt.megatrend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInputDto {
    private String id;
    private String name;
    private String description;
    private MultipartFile image;
    private Double price;
    private Double originalPrice;
    private String country;
    private List<Integer> size;
    private LocalDateTime createdAt;
}