package co.edu.udea.productservice.controller.category;

import co.edu.udea.productservice.mapper.category.ICategoryMapper;
import co.edu.udea.productservice.mapper.category.IListCategoryMapper;
import co.edu.udea.productservice.model.dto.category.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ICategoryMapper iCategoryMapper;
    @Autowired
    private IListCategoryMapper iListCategoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listAllCategory() {

        List<CategoryEntity> categories = iCategoryService.listAllCategory();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CategoryDTO> categoriesDTO = iListCategoryMapper.modelToDTO(categories);
        return ResponseEntity.ok(categoriesDTO);

    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<CategoryDTO> findCategoryByCode(@PathVariable("code") String code){
        CategoryEntity categoryEntity = iCategoryService.findCategoryByCode(code);
        if (categoryEntity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iCategoryMapper.modelToDTO(categoryEntity));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = iCategoryService.createCategory(iCategoryMapper.DTOToModel(categoryDTO));
        CategoryDTO categoryDTODB = iCategoryMapper.modelToDTO(categoryEntity);
        return ResponseEntity.ok(categoryDTODB);
    }

    @PutMapping(value = "/{code}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("code") String code, @RequestBody CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = iCategoryService.findCategoryByCode(code);
        if (categoryEntity == null){
            return ResponseEntity.notFound().build();
        }
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setCode(categoryEntity.getCode());
        CategoryEntity categoryDB = iCategoryService.updateCategory(iCategoryMapper.DTOToModel(categoryDTO));
        return ResponseEntity.ok(iCategoryMapper.modelToDTO(categoryDB));

    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<CategoryDTO> deleteCategoryById(@PathVariable("code") String code){
        CategoryEntity categoryEntity = iCategoryService.findCategoryByCode(code);
        if (categoryEntity == null){
            ResponseEntity.notFound().build();
        }
        CategoryDTO categoryDTO = iCategoryMapper.modelToDTO(iCategoryService.deleteCategoryById(categoryEntity.getId()));
        return ResponseEntity.ok(categoryDTO);
    }

}
