package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.BalanceDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.model.Balance;
import mt.megatrend.repository.BalanceRepository;
import mt.megatrend.service.BalanceService;
import mt.megatrend.service.mapper.BalanceMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static mt.megatrend.service.status.AppStatusMessage.*;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final BalanceMapper balanceMapper;
    private final BalanceRepository balanceRepository;

    @Override
    public ResponseDto<BalanceDto> update(BalanceDto balanceDto) {
        try {
            Optional<Balance> byId = balanceRepository.findById(1);
            if (byId.isPresent()){
                Balance balance = byId.get();

                balance.setBalance(balanceDto.getBalance() != null ? balanceDto.getBalance() : balance.getBalance());
                balance.setProfit(balanceDto.getProfit() != null ? balanceDto.getProfit() : balance.getProfit());
                balance.setPriceOfAllProducts(balanceDto.getPriceOfAllProducts() != null ? balanceDto.getPriceOfAllProducts() : balance.getPriceOfAllProducts());

                balanceRepository.save(balance);

                return ResponseDto.<BalanceDto>builder()
                        .success(true)
                        .message(OK)
                        .data(balanceMapper.toDto(balance))
                        .build();
            } else {
                balanceRepository.save(balanceMapper.toEntity(balanceDto));
                return ResponseDto.<BalanceDto>builder()
                        .message(OK)
                        .success(true)
                        .data(balanceDto)
                        .build();
            }
        } catch (Exception e){
            return ResponseDto.<BalanceDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<BalanceDto> get() {
        try {
            Optional<Balance> byId = balanceRepository.findById(1);
            if (byId.isPresent()){
                return ResponseDto.<BalanceDto>builder()
                        .success(true)
                        .message(OK)
                        .data(balanceMapper.toDto(byId.get()))
                        .build();
            } else {
                return ResponseDto.<BalanceDto>builder()
                        .message(NOT_FOUND)
                        .build();
            }
        } catch (Exception e){
            return ResponseDto.<BalanceDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }
}
