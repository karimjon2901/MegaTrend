package mt.megatrend.service;

import mt.megatrend.dto.BalanceDto;
import mt.megatrend.dto.ResponseDto;

public interface BalanceService {
    ResponseDto<BalanceDto> update(BalanceDto balanceDto);

    ResponseDto<BalanceDto> get();
}
