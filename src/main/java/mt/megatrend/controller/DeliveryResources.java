package mt.megatrend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.DeliveryDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryResources {
    private final DeliveryService deliveryService;

    @Operation(
            method = "Add new Delivery",
            description = "Need to send DeliveryDto to this endpoint to create new delivery",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Delivery info",
                    content = @Content(mediaType = "application/json")),
            summary = "add"
    )
    @PostMapping
    public ResponseDto<DeliveryDto> add(@RequestBody DeliveryDto deliveryDto){
        return deliveryService.add(deliveryDto);
    }

    @Operation(
            method = "Get all Delivery",
            description = "This endpoint return all delivery",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Delivery info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get all"
    )
    @GetMapping
    public ResponseDto<List<DeliveryDto>> getAll(){
        return deliveryService.getAll();
    }

    @Operation(
            method = "Get delivery by id",
            description = "Need to send id to this endpoint to get delivery",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Delivery info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get by id"
    )
    @GetMapping("/{id}")
    public ResponseDto<DeliveryDto> getById(@PathVariable String id){
        return deliveryService.getById(id);
    }

    @Operation(
            method = "Update Delivery",
            description = "Need to send DeliveryDto to this endpoint to update Delivery",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Delivery info",
                    content = @Content(mediaType = "application/json")),
            summary = "Update"
    )
    @PatchMapping
    public ResponseDto<DeliveryDto> update(@RequestBody DeliveryDto deliveryDto){
        return deliveryService.update(deliveryDto);
    }
}
