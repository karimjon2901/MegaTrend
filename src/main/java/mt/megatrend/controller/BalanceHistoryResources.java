package mt.megatrend.controller;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.BalanceHistoryDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.BalanceHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class BalanceHistoryResources {
    private final BalanceHistoryService balanceHistoryService;
    @PostMapping
    public ResponseDto<BalanceHistoryDto> add(@RequestBody BalanceHistoryDto balanceHistoryDto){
        return balanceHistoryService.add(balanceHistoryDto);
    }
    @GetMapping
    public ResponseDto<List<BalanceHistoryDto>> getAll(){
        return balanceHistoryService.getAll();
    }

    @PatchMapping
    public ResponseDto<BalanceHistoryDto> update(@RequestBody BalanceHistoryDto balanceHistoryDto){
        return balanceHistoryService.update(balanceHistoryDto);
    }
}
