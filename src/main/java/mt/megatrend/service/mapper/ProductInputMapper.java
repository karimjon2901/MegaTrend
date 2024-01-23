package mt.megatrend.service.mapper;

import mt.megatrend.config.S3File;
import mt.megatrend.dto.ProductDto;
import mt.megatrend.dto.ProductInputDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public class ProductInputMapper{
    @Autowired
    protected S3File s3File;

    public ProductDto toDto(ProductInputDto productInputDto) {
        if (productInputDto == null){
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId(productInputDto.getId());
        productDto.setName(productInputDto.getName());
        productDto.setDescription(productInputDto.getDescription());
        productDto.setImage(s3File.postFile(productInputDto.getImage()));
        productDto.setOriginalPrice(productInputDto.getOriginalPrice());
        productDto.setPrice(productInputDto.getPrice());
        productDto.setCountry(productInputDto.getCountry());
        productDto.setSize(productInputDto.getSize());

        return productDto;
    }
}
