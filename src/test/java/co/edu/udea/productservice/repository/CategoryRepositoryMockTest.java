package co.edu.udea.productservice.repository;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.repository.ICategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class CategoryRepositoryMockTest {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Test
    public void whenFindByCode_thenReturnCategory(){

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCode("C01");
        categoryEntity.setName("Honey");
        categoryEntity.setStatus("CREATED");
        categoryEntity.setCreateAt(new Date());
        iCategoryRepository.save(categoryEntity);

        CategoryEntity categoryEntityDB = iCategoryRepository.findByCode(categoryEntity.getCode()).orElse(null);

        Assertions.assertThat(categoryEntityDB.getName()).isEqualTo(categoryEntity.getName());

    }

}
