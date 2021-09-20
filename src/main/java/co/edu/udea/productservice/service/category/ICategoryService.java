package co.edu.udea.productservice.service.category;

import co.edu.udea.productservice.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    CategoryEntity createCategory(CategoryEntity category);

    CategoryEntity findCategoryById(Long id);

    CategoryEntity findCategoryByCode(String code);

    List<CategoryEntity> listAllCategory();

    CategoryEntity updateCategory(CategoryEntity category);

    CategoryEntity deleteCategoryById(Long id);

}
