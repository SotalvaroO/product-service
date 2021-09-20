package co.edu.udea.productservice.mapper.category;

import co.edu.udea.productservice.model.dto.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;

public interface ICategoryMapper {

    CategoryDTO modelToDTO(CategoryEntity category);
    CategoryEntity DTOToModel(CategoryDTO categoryDTO);

}
