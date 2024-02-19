package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.DeliveryDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.repository.DeliveryRepository;
import mt.megatrend.service.DeliveryService;
import mt.megatrend.service.IdGenerator;
import mt.megatrend.service.mapper.DeliveryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static mt.megatrend.service.status.AppStatusMessage.*;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryMapper deliveryMapper;
    private final DeliveryRepository deliveryRepository;
    private final IdGenerator idGenerator;

    @Override
    public ResponseDto<DeliveryDto> add(DeliveryDto deliveryDto) {
        try {
            deliveryDto.setId(idGenerator.generate());
            deliveryRepository.save(deliveryMapper.toEntity(deliveryDto));
            return ResponseDto.<DeliveryDto>builder()
                    .success(true)
                    .message(OK)
                    .data(deliveryDto)
                    .build();
        } catch (Exception e){
            return ResponseDto.<DeliveryDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<List<DeliveryDto>> getAll() {
        try {
            return ResponseDto.<List<DeliveryDto>>builder()
                    .success(true)
                    .message(OK)
                    .data(deliveryRepository.findAll().stream().map(deliveryMapper::toDto).toList())
                    .build();
        } catch (Exception e){
            return ResponseDto.<List<DeliveryDto>>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<DeliveryDto> getById(String id) {
        if (id == null){
            return ResponseDto.<DeliveryDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            return deliveryRepository.findById(id)
                    .map(delivery -> ResponseDto.<DeliveryDto>builder()
                            .message(OK)
                            .success(true)
                            .data(deliveryMapper.toDto(delivery))
                            .build())
                    .orElse(ResponseDto.<DeliveryDto>builder()
                            .message(NOT_FOUND)
                            .build());
        } catch (Exception e){
            return ResponseDto.<DeliveryDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<DeliveryDto> update(DeliveryDto deliveryDto) {
        return null;
    }
}
