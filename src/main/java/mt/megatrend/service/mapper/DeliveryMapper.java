package mt.megatrend.service.mapper;

import mt.megatrend.dto.DeliveryDto;
import mt.megatrend.model.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DeliveryMapper implements CommonMapper<DeliveryDto, Delivery>{
    @Override
    public abstract DeliveryDto toDto(Delivery delivery);

    @Override
    public abstract Delivery toEntity(DeliveryDto deliveryDto);
}
