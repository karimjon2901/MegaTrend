package mt.megatrend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto <T>{
    private boolean success;
    private String message;
    private T data;
}
