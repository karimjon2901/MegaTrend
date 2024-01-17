package mt.megatrend.service;

import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface ProductService {
    ResponseDto<ProductDto> add(ProductDto productDto);

    ResponseDto<List<ProductDto>> getAll();

    ResponseDto<ProductDto> getById(String id);

    ResponseDto<ProductDto> update(ProductDto productDto);

    ResponseDto<ProductDto> delete(String id);

    ResponseDto<List<ProductDto>> getByCategoryId(String id);
}
