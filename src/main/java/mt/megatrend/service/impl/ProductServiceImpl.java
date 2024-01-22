package mt.megatrend.service.impl;

import lombok.RequiredArgsConstructor;
import mt.megatrend.config.S3File;
import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ProductInputDto;
import mt.megatrend.dto.ResponseDto;
import mt.megatrend.model.Product;
import mt.megatrend.repository.ProductRepository;
import mt.megatrend.service.IdGenerator;
import mt.megatrend.service.ProductService;
import mt.megatrend.service.mapper.ProductInputMapper;
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
    private final ProductInputMapper productInputMapper;
    private final S3File s3File;

    @Override
    public ResponseDto<ProductDto> add(ProductInputDto productInputDto) {
        try {
            productInputDto.setId(idGenerator.generate());
            ProductDto productDto = productInputMapper.toDto(productInputDto);
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
    public ResponseDto<ProductDto> update(ProductInputDto productInputDto) {
        if (productInputDto.getId() == null){
            return ResponseDto.<ProductDto>builder()
                    .message(NULL_ID)
                    .build();
        }
        try {
            Optional<Product> byId = productRepository.findById(productInputDto.getId());
            if (byId.isPresent()){
                Product product = byId.get();

                product.setName(productInputDto.getName() != null ? productInputDto.getName() : product.getName());
                product.setDescription(productInputDto.getDescription() != null ? productInputDto.getDescription() : product.getDescription());
                product.setPrice(productInputDto.getPrice() != null ? productInputDto.getPrice() : product.getPrice());
                product.setOriginalPrice(productInputDto.getOriginalPrice() != null ? productInputDto.getOriginalPrice() : product.getOriginalPrice());
                product.setCountry(productInputDto.getCountry() != null ? productInputDto.getCountry() : product.getCountry());
                product.setImage(productInputDto.getImage() != null ? s3File.postFile(productInputDto.getImage()) : product.getImage());
                product.setSize(productInputDto.getSize() != null ? toStr(productInputDto.getSize()) : product.getSize());

                return ResponseDto.<ProductDto>builder()
                        .message(OK)
                        .success(true)
                        .data(productMapper.toDto(product))
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
    protected String toStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer s: list) sb.append(s).append("/sp/");
        return sb.toString();
    }
}
