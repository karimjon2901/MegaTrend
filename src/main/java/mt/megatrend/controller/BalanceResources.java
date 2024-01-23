package mt.megatrend.controller;

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

    @PatchMapping
    public ResponseDto<BalanceDto> update(@RequestBody BalanceDto balanceDto){
        return balanceService.update(balanceDto);
    }

    @GetMapping
    public ResponseDto<BalanceDto> get(){
        return balanceService.get();
    }
}
