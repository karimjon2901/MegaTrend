package mt.megatrend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ProductInputDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.service.impl.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResources {
    private final ProductServiceImpl productService;
    @Operation(
            method = "Add new product",
            description = "Need to send ProductDto to this endpoint to create new product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product info",
                    content = @Content(mediaType = "multipart/form-data")),
            summary = "add"
    )
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto<ProductDto> add(@ModelAttribute ProductInputDto productInputDto){
        return productService.add(productInputDto);
    }

    @Operation(
            method = "Get all products",
            description = "This endpoint return all products",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get all"
    )
    @GetMapping
    public ResponseDto<List<ProductDto>> getAll(){
        return productService.getAll();
    }
    @Operation(
            method = "Get product by id",
            description = "Need to send id to this endpoint to get product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product info",
                    content = @Content(mediaType = "application/json")),
            summary = "Get by id"
    )
    @GetMapping("/{id}")
    public ResponseDto<ProductDto> getById(@PathVariable String id){
        return productService.getById(id);
    }

    @Operation(
            method = "Update product",
            description = "Need to send ProductDto to this endpoint to update product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product info",
                    content = @Content(mediaType = "multipart/form-data")),
            summary = "Update"
    )
    @PatchMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto<ProductDto> update(@ModelAttribute ProductInputDto productInputDto){
        return productService.update(productInputDto);
    }

    @Operation(
            method = "Delete product",
            description = "Need to send product id to this endpoint to delete this product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Product info",
                    content = @Content(mediaType = "application/json")),
            summary = "Delete"
    )
    @DeleteMapping("/{id}")
    public ResponseDto<ProductDto> delete(@PathVariable String id){
        return productService.delete(id);
    }
}
