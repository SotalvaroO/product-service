package co.edu.udea.productservice.service.product;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.model.entity.ProductEntity;
import co.edu.udea.productservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = findProductByCode(product.getCode());
        if (productEntity != null) {
            return productEntity;
        }
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        productEntity = iProductRepository.save(product);
        return productEntity;
    }

    @Override
    public ProductEntity findProductById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity findProductByCode(String code) {
        return iProductRepository.findByCode(code).orElse(null);
    }

    @Override
    public List<ProductEntity> listAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public List<ProductEntity> listByProductCategory(CategoryEntity category) {
        return iProductRepository.findAllByCategory(category);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        ProductEntity productEntity = findProductById(product.getId());
        if (productEntity == null) {
            return null;
        }
        productEntity.setCode(product.getCode());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategory(product.getCategory());
        productEntity.setPrice(product.getPrice());
        productEntity.setImgReference(product.getImgReference());

        return iProductRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateStock(Long id, Double quantity) {
        ProductEntity product = findProductById(id);
        if (product == null) {
            return null;
        }
        Double stock = product.getStock() + quantity;
        product.setStock(stock);
        return iProductRepository.save(product);
    }

    @Override
    public ProductEntity deleteProductById(Long id) {
        ProductEntity productEntity = findProductById(id);
        if (productEntity == null) {
            return null;
        }
        productEntity.setStatus("DELETED");
        return iProductRepository.save(productEntity);
    }
}
