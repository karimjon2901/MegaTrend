package mt.megatrend.service.mapper;

import mt.megatrend.dto.BalanceHistoryDto;
import mt.megatrend.model.BalanceHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BalanceHistoryMapper implements CommonMapper<BalanceHistoryDto, BalanceHistory>{
    @Override
    public abstract BalanceHistoryDto toDto(BalanceHistory balanceHistory);

    @Override
    public abstract BalanceHistory toEntity(BalanceHistoryDto balanceHistoryDto);
}
