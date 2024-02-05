package mt.megatrend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.BalanceHistoryDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.BalanceHistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class BalanceHistoryResources {
    private final BalanceHistoryService balanceHistoryService;

    @Operation(
            method = "Add new BalanceHistory",
            description = "Need to send BalanceHistoryDto to this endpoint to create new BalanceHistory",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "BalanceHistory info",
                    content = @Content(mediaType = "application/json")),
            summary = "add"
    )
    @PostMapping
    public ResponseDto<BalanceHistoryDto> add(@RequestBody BalanceHistoryDto balanceHistoryDto){
        return balanceHistoryService.add(balanceHistoryDto);
    }

    @Operation(
            method = "Get all BalanceHistory",
            description = "This endpoint return all BalanceHistory",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "BalanceHistory info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get all"
    )
    @GetMapping
    public ResponseDto<List<BalanceHistoryDto>> getAll(){
        return balanceHistoryService.getAll();
    }

    @Operation(
            method = "Update balance history",
            description = "Need to send BalanceHistoryDto to this endpoint to update BalanceHistory",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "BalanceHistory info",
                    content = @Content(mediaType = "application/json")),
            summary = "Update"
    )
    @PatchMapping
    public ResponseDto<BalanceHistoryDto> update(@RequestBody BalanceHistoryDto balanceHistoryDto){
        return balanceHistoryService.update(balanceHistoryDto);
    }

    @Operation(
            method = "Get all BalanceHistory between dates",
            description = "This endpoint return all BalanceHistory by between dates.  Need to send start year, month, day, hour, minute and end year, month, day, hour, minute to this endpoint",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "BalanceHistory info",
                    content = @Content(mediaType = "application/json")),
            summary = "Between dates"
    )
    @GetMapping("/by-time")
    public ResponseDto<List<BalanceHistoryDto>> getBalanceHistoryBetweenDates(@RequestParam int sYear, int sMonth, int sDay, int sHour, int sMinute, int eYear, int eMonth, int eDay, int eHour, int eMinute){
        LocalDateTime startDate = LocalDateTime.of(sYear, sMonth, sDay, sHour, sMinute);
        LocalDateTime endDate = LocalDateTime.of(eYear, eMonth, eDay, eHour, eMinute, 59);
        return balanceHistoryService.getBalanceHistoryBetweenDates(startDate,endDate);
    }
}
