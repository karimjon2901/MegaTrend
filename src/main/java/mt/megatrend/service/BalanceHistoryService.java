package mt.megatrend.service;

import mt.megatrend.dto.BalanceHistoryDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface BalanceHistoryService {
    ResponseDto<BalanceHistoryDto> add(BalanceHistoryDto balanceHistoryDto);

    ResponseDto<List<BalanceHistoryDto>> getAll();

    ResponseDto<BalanceHistoryDto> update(BalanceHistoryDto balanceHistoryDto);
}
