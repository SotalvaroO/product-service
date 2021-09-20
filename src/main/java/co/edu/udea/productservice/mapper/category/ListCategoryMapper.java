package co.edu.udea.productservice.mapper.category;

import co.edu.udea.productservice.model.dto.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListCategoryMapper implements IListCategoryMapper {

    @Autowired
    private ICategoryMapper iCategoryMapper;


    @Override
    public List<CategoryDTO> modelToDTO(List<CategoryEntity> categories) {
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        for (CategoryEntity ce : categories
        ) {
            categoriesDTO.add(iCategoryMapper.modelToDTO(ce));
        }

        return categoriesDTO;

    }
}
