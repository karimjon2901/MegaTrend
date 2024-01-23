package mt.megatrend.service.mapper;

import mt.megatrend.dto.BalanceDto;
import mt.megatrend.model.Balance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BalanceMapper extends CommonMapper<BalanceDto, Balance> {
}
