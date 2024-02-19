package mt.megatrend.service;

import mt.megatrend.dto.DeliveryCityDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface DeliveryCityService {
    ResponseDto<DeliveryCityDto> add(DeliveryCityDto deliveryCityDto);

    ResponseDto<List<DeliveryCityDto>> getAll();

    ResponseDto<DeliveryCityDto> update(DeliveryCityDto deliveryCityDto);

    ResponseDto<DeliveryCityDto> getById(String id);
}
