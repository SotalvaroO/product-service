package co.edu.udea.productservice.config.category;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.repository.ICategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(ICategoryRepository iCategoryRepository) {
        return args -> {
            CategoryEntity categoryHoney = new CategoryEntity(1L, "COB1", "Honey", "CREATED", new Date());
            CategoryEntity categoryGrano = new CategoryEntity(2L, "COB2", "Grano", "CREATED", new Date());
            CategoryEntity categoryInstant = new CategoryEntity(3L, "COB3", "instant", "CREATED", new Date());
            iCategoryRepository.saveAll(
                    List.of(categoryHoney, categoryGrano, categoryInstant)
            );
        };
    }

}
