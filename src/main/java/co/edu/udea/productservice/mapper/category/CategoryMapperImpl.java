package co.edu.udea.productservice.mapper.category;

import co.edu.udea.productservice.model.dto.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements ICategoryMapper {
    @Override
    public CategoryDTO modelToDTO(CategoryEntity category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (category.getId() != null) {
            categoryDTO.setId(category.getId());
        }
        categoryDTO.setCode(category.getCode());
        categoryDTO.setName(category.getName());
        categoryDTO.setStatus(category.getStatus());
        categoryDTO.setCreateAt(category.getCreateAt());

        return categoryDTO;
    }

    @Override
    public CategoryEntity DTOToModel(CategoryDTO categoryDTO) {
        CategoryEntity category = new CategoryEntity();
        if (categoryDTO.getId() != null){
            category.setId(categoryDTO.getId());
        }
        category.setCode(categoryDTO.getCode());
        category.setName(categoryDTO.getName());
        category.setStatus(categoryDTO.getStatus());
        category.setCreateAt(categoryDTO.getCreateAt());

        return category;
    }
}
