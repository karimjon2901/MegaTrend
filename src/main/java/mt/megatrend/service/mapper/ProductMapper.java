package mt.megatrend.service.mapper;

import mt.megatrend.dto.ProductDto;
import mt.megatrend.model.Product;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements CommonMapper<ProductDto, Product>{
    @Override
    public ProductDto toDto(Product product){
        if ( product == null ){
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setCountry(product.getCountry());
        productDto.setPrice(product.getPrice());
        productDto.setSize(toList(product.getSize()));
        productDto.setDescription(product.getDescription());
        productDto.setOriginalPrice(product.getOriginalPrice());
        productDto.setCreatedAt(product.getCreatedAt());

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto){
        if ( productDto == null){
            return null;
        }

        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setOriginalPrice(productDto.getOriginalPrice());
        product.setCountry(productDto.getCountry());
        product.setSize(toStr(productDto.getSize()));

        return product;
    }


    protected String toStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer s: list) sb.append(s).append("/sp/");
        return sb.toString();
    }

    protected List<Integer> toList(String s){
        return Arrays.stream(s.split("/sp/")).map(Integer::parseInt).toList();
    }
}
