package mt.megatrend.service;

import mt.megatrend.dto.DeliveryDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface DeliveryService {
    ResponseDto<DeliveryDto> add(DeliveryDto deliveryDto);

    ResponseDto<List<DeliveryDto>> getAll();

    ResponseDto<DeliveryDto> getById(String id);

    ResponseDto<DeliveryDto> update(DeliveryDto deliveryDto);
}
