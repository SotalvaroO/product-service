package co.edu.udea.productservice.service.product;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.model.entity.ProductEntity;

import java.util.List;

public interface IProductService {

    ProductEntity createProduct(ProductEntity product);

    ProductEntity findProductById(Long id);

    ProductEntity findProductByCode(String code);

    List<ProductEntity> listAllProduct();

    List<ProductEntity> listByProductCategory(CategoryEntity category);

    ProductEntity updateProduct(ProductEntity product);

    ProductEntity updateStock(Long id, Double quantity);

    ProductEntity deleteProductById(Long id);


}
