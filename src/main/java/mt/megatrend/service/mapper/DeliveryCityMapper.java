package mt.megatrend.service.mapper;

import mt.megatrend.dto.DeliveryCityDto;
import mt.megatrend.model.DeliveryCity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DeliveryCityMapper implements CommonMapper<DeliveryCityDto, DeliveryCity>{
    @Override
    public abstract DeliveryCityDto toDto(DeliveryCity deliveryCity);

    @Override
    public abstract DeliveryCity toEntity(DeliveryCityDto deliveryCityDto);
}
