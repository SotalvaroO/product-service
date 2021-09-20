package co.edu.udea.productservice.mapper.category;

import co.edu.udea.productservice.model.dto.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;

import java.util.List;

public interface IListCategoryMapper {

    List<CategoryDTO> modelToDTO(List<CategoryEntity> categories);

}
