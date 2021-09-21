package co.edu.udea.productservice.repository;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);
    List<ProductEntity> findAllByCategory(CategoryEntity category);

}
