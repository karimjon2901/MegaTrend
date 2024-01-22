package mt.megatrend.service;

import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ProductInputDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface ProductService {
    ResponseDto<ProductDto> add(ProductInputDto productInputDto);

    ResponseDto<List<ProductDto>> getAll();

    ResponseDto<ProductDto> getById(String id);

    ResponseDto<ProductDto> update(ProductInputDto productInputDto);

    ResponseDto<ProductDto> delete(String id);
}
