package mt.megatrend.service;

import mt.megatrend.dto.CategoryDto;
import mt.megatrend.dto.ResponseDto;

import java.util.List;

public interface CategoryService {

    ResponseDto<CategoryDto> getById(String id);

    ResponseDto<List<CategoryDto>> getAll();

    ResponseDto<CategoryDto> addCategory(CategoryDto categoryDto);

    ResponseDto<Void> delete(String id);

    ResponseDto<CategoryDto> update(CategoryDto categoryDto);
}
