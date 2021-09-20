package co.edu.udea.productservice.service.category;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        CategoryEntity categoryEntity = findCategoryByCode(category.getCode());
        if (categoryEntity != null) {
            return categoryEntity;
        }
        category.setStatus("CREATED");
        category.setCreateAt(new Date());
        categoryEntity = iCategoryRepository.save(category);
        return categoryEntity;
    }

    @Override
    public CategoryEntity findCategoryById(Long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity findCategoryByCode(String code) {
        return iCategoryRepository.findByCode(code).orElse(null);
    }

    @Override
    public List<CategoryEntity> listAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        CategoryEntity categoryEntity = findCategoryById(category.getId());
        if (categoryEntity == null){
            return null;
        }
        categoryEntity.setName(category.getName());
        return iCategoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity deleteCategoryById(Long id) {
        CategoryEntity categoryEntity = findCategoryById(id);
        if (categoryEntity == null){
            return null;
        }
        categoryEntity.setStatus("DELETED");
        return iCategoryRepository.save(categoryEntity);
    }
}
