package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.model.Product;
import mt.megatrend.repository.ProductRepository;
import mt.megatrend.service.IdGenerator;
import mt.megatrend.service.ProductService;
import mt.megatrend.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static mt.megatrend.service.status.AppStatusMessage.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final IdGenerator idGenerator;

    @Override
    public ResponseDto<ProductDto> add(ProductDto productDto) {
        productDto.setId(idGenerator.generate());
        try {
            productRepository.save(productMapper.toEntity(productDto));
            return ResponseDto.<ProductDto>builder()
                    .message(OK)
                    .success(true)
                    .data(productDto)
                    .build();
        } catch (Exception e){
            return ResponseDto.<ProductDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<List<ProductDto>> getAll() {
        try {
            return ResponseDto.<List<ProductDto>>builder()
                    .message(OK)
                    .success(true)
                    .data(productRepository.findAll().stream().map(productMapper::toDto).toList())
                    .build();
        } catch (Exception e){
            return ResponseDto.<List<ProductDto>>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<ProductDto> getById(String id) {
        if (id == null){
            return ResponseDto.<ProductDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            return productRepository.findById(id)
                    .map(product -> ResponseDto.<ProductDto>builder()
                            .message(OK)
                            .success(true)
                            .data(productMapper.toDto(product))
                            .build())
                    .orElse(ResponseDto.<ProductDto>builder()
                            .message(NOT_FOUND)
                            .build());
        } catch (Exception e){
            return ResponseDto.<ProductDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<ProductDto> update(ProductDto productDto) {
        return null;
    }

    @Override
    public ResponseDto<ProductDto> delete(String id) {
        if (id == null){
            return ResponseDto.<ProductDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            Optional<Product> byId = productRepository.findById(id);
            if (byId.isPresent()){
                productRepository.deleteById(id);
                return ResponseDto.<ProductDto>builder()
                        .success(true)
                        .message(OK)
                        .data(productMapper.toDto(byId.get()))
                        .build();
            } else {
                return ResponseDto.<ProductDto>builder()
                        .message(NOT_FOUND)
                        .build();
            }
        } catch (Exception e){
            return ResponseDto.<ProductDto>builder()
                    .message(DATABASE_ERROR + e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<List<ProductDto>> getByCategoryId(String id) {
        if (id == null){
            return ResponseDto.<List<ProductDto>>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            List<Product> byId = productRepository.findAllByCategoryId(id);
            if (byId.isEmpty()){
                return ResponseDto.<List<ProductDto>>builder()
                        .message(NOT_FOUND)
                        .build();
            }

            return ResponseDto.<List<ProductDto>>builder()
                    .success(true)
                    .message(OK)
                    .data(byId.stream().map(productMapper::toDto).toList())
                    .build();
        } catch (Exception e){
            return ResponseDto.<List<ProductDto>>builder()
                    .message(DATABASE_ERROR + " : " + e.getMessage())
                    .build();
        }
    }
}
