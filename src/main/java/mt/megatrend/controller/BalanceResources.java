package mt.megatrend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.BalanceDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.BalanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceResources {
    private final BalanceService balanceService;

    @Operation(
            method = "Update balance",
            description = "Need to send BalanceDto to this endpoint to update balance",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Balance info",
                    content = @Content(mediaType = "application/json")),
            summary = "Update"
    )
    @PatchMapping
    public ResponseDto<BalanceDto> update(@RequestBody BalanceDto balanceDto){
        return balanceService.update(balanceDto);
    }

    @Operation(
            method = "Get information of balance",
            description = "This endpoint return all information of balance",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Balance info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get"
    )
    @GetMapping
    public ResponseDto<BalanceDto> get(){
        return balanceService.get();
    }
}
