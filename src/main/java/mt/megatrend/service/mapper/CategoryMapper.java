package mt.megatrend.service.mapper;

import mt.megatrend.dto.CategoryDto;
import mt.megatrend.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper implements CommonMapper<CategoryDto, Category>{
    @Override
    public abstract CategoryDto toDto(Category category);

    @Override
    public abstract Category toEntity(CategoryDto categoryDto);
}