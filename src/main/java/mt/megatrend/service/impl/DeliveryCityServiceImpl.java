package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.DeliveryCityDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.repository.DeliveryCityRepository;
import mt.megatrend.service.DeliveryCityService;
import mt.megatrend.service.IdGenerator;
import mt.megatrend.service.mapper.DeliveryCityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static mt.megatrend.service.status.AppStatusMessage.*;

@Service
@RequiredArgsConstructor
public class DeliveryCityServiceImpl implements DeliveryCityService {
    private final DeliveryCityRepository deliveryCityRepository;
    private final DeliveryCityMapper deliveryCityMapper;
    private final IdGenerator idGenerator;

    @Override
    public ResponseDto<DeliveryCityDto> add(DeliveryCityDto deliveryCityDto) {
        deliveryCityDto.setId(idGenerator.generate());
        try {
            deliveryCityRepository.save(deliveryCityMapper.toEntity(deliveryCityDto));
            return ResponseDto.<DeliveryCityDto>builder()
                    .message(OK)
                    .success(true)
                    .data(deliveryCityDto)
                    .build();
        }catch (Exception e){
            return ResponseDto.<DeliveryCityDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<List<DeliveryCityDto>> getAll() {
        try {
            return ResponseDto.<List<DeliveryCityDto>>builder()
                    .success(true)
                    .message(OK)
                    .data(deliveryCityRepository.findAll().stream().map(deliveryCityMapper::toDto).toList())
                    .build();
        } catch (Exception e){
            return ResponseDto.<List<DeliveryCityDto>>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<DeliveryCityDto> update(DeliveryCityDto deliveryCityDto) {
        return null;
    }

    @Override
    public ResponseDto<DeliveryCityDto> getById(String id) {
        if (id == null){
            return ResponseDto.<DeliveryCityDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            return deliveryCityRepository.findById(id)
                    .map(deliveryCity -> ResponseDto.<DeliveryCityDto>builder()
                            .message(OK)
                            .success(true)
                            .data(deliveryCityMapper.toDto(deliveryCity))
                            .build())
                    .orElse(ResponseDto.<DeliveryCityDto>builder()
                            .message(NOT_FOUND)
                            .build());
        } catch (Exception e){
            return ResponseDto.<DeliveryCityDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }
}
