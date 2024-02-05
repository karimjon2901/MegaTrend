package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.BalanceHistoryDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.model.Balance;
import mt.megatrend.model.BalanceHistory;
import mt.megatrend.repository.BalanceHistoryRepository;
import mt.megatrend.repository.BalanceRepository;
import mt.megatrend.service.BalanceHistoryService;
import mt.megatrend.service.IdGenerator;
import mt.megatrend.service.mapper.BalanceHistoryMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static mt.megatrend.service.status.AppStatusMessage.*;

@Service
@RequiredArgsConstructor
public class BalanceHistoryServiceImpl implements BalanceHistoryService {
    private final BalanceHistoryRepository balanceHistoryRepository;
    private final BalanceHistoryMapper balanceHistoryMapper;
    private final IdGenerator idGenerator;
    private final BalanceRepository balanceRepository;

    @Override
    public ResponseDto<BalanceHistoryDto> add(BalanceHistoryDto balanceHistoryDto) {
        try {
            Balance balance = balanceRepository.findById(1).orElseGet(Balance::new);
            balance.setBalance(balance.getBalance() + balanceHistoryDto.getMoney());
            balanceRepository.save(balance);
            balanceHistoryDto.setId(idGenerator.generate());
            balanceHistoryRepository.save(balanceHistoryMapper.toEntity(balanceHistoryDto));
            return ResponseDto.<BalanceHistoryDto>builder()
                    .success(true)
                    .message(OK)
                    .data(balanceHistoryDto)
                    .build();
        } catch (Exception e){
            return ResponseDto.<BalanceHistoryDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<List<BalanceHistoryDto>> getAll() {
        try {
            return ResponseDto.<List<BalanceHistoryDto>>builder()
                    .success(true)
                    .message(OK)
                    .data(balanceHistoryRepository.findAll().stream().map(balanceHistoryMapper::toDto).toList())
                    .build();
        }catch (Exception e){
            return ResponseDto.<List<BalanceHistoryDto>>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<BalanceHistoryDto> update(BalanceHistoryDto balanceHistoryDto) {
        if (balanceHistoryDto.getId() == null){
            return ResponseDto.<BalanceHistoryDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            Optional<BalanceHistory> byId = balanceHistoryRepository.findById(balanceHistoryDto.getId());
            if (byId.isPresent()){
                BalanceHistory balanceHistory = byId.get();

                balanceHistory.setDescription(balanceHistoryDto.getDescription() != null ? balanceHistoryDto.getDescription() : balanceHistory.getDescription());
                balanceHistory.setTime(LocalDateTime.now());
                if (balanceHistoryDto.getMoney() != null){
                    Balance balance = balanceRepository.findById(1).orElseGet(Balance::new);
                    balance.setBalance((balance.getBalance() - balanceHistory.getMoney()) + balanceHistoryDto.getMoney());
                    balanceHistory.setMoney(balanceHistoryDto.getMoney());
                    balanceRepository.save(balance);
                }

                balanceHistoryRepository.save(balanceHistory);
                return ResponseDto.<BalanceHistoryDto>builder()
                        .success(true)
                        .message(OK)
                        .data(balanceHistoryMapper.toDto(balanceHistory))
                        .build();
            } else {
                return ResponseDto.<BalanceHistoryDto>builder()
                        .message(NOT_FOUND)
                        .build();
            }
        }catch (Exception e){
            return ResponseDto.<BalanceHistoryDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }
    @Override
    public ResponseDto<List<BalanceHistoryDto>> getBalanceHistoryBetweenDates(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ResponseDto.<List<BalanceHistoryDto>>builder()
                .message(OK)
                .success(true)
                .data(balanceHistoryRepository.findByTimeBetween(startDateTime, endDateTime).stream().map(balanceHistoryMapper::toDto).toList())
                .build();
    }
}
