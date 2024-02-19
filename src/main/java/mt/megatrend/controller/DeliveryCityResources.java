package mt.megatrend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.DeliveryCityDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.DeliveryCityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class DeliveryCityResources {
    private final DeliveryCityService deliveryCityService;

    @Operation(
            method = "Add new DeliveryCity",
            description = "Need to send DeliveryCityDto to this endpoint to create new DeliveryCity",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "DeliveryCity info",
                    content = @Content(mediaType = "application/json")),
            summary = "add"
    )
    @PostMapping
    public ResponseDto<DeliveryCityDto> add(@RequestBody DeliveryCityDto deliveryCityDto){
        return deliveryCityService.add(deliveryCityDto);
    }

    @Operation(
            method = "Get all DeliveryCityDto",
            description = "This endpoint return all deliveryCityDto",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "DeliveryCity info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get all"
    )
    @GetMapping
    public ResponseDto<List<DeliveryCityDto>> getAll(){
        return deliveryCityService.getAll();
    }

    @Operation(
            method = "Get DeliveryCity by id",
            description = "Need to send id to this endpoint to get DeliveryCity",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "DeliveryCity info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get by id"
    )
    @GetMapping("/{id}")
    public ResponseDto<DeliveryCityDto> getById(@PathVariable String id){
        return deliveryCityService.getById(id);
    }

    @Operation(
            method = "Update DeliveryCity",
            description = "Need to send DeliveryCityDto to this endpoint to update deliveryCity",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "DeliveryCity info",
                    content = @Content(mediaType = "application/json")),
            summary = "Update"
    )
    @PatchMapping
    public ResponseDto<DeliveryCityDto> update(@RequestBody DeliveryCityDto deliveryCityDto){
        return deliveryCityService.update(deliveryCityDto);
    }
}
