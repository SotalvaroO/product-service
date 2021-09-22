package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.model.dto.product.ProductRequestDTO;
import co.edu.udea.productservice.model.entity.ProductEntity;
import co.edu.udea.productservice.service.category.ICategoryService;
import co.edu.udea.productservice.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapperImpl implements IProductRequestMapper {

    @Autowired
    private ICategoryService iCategoryService;

    @Override
    public ProductRequestDTO modelToDTO(ProductEntity product) {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        if (product.getId() != null) {
            productRequestDTO.setId(product.getId());
        }
        productRequestDTO.setCode(product.getCode());
        productRequestDTO.setName(product.getName());
        productRequestDTO.setDescription(product.getDescription());
        productRequestDTO.setCategory(product.getCategory().getId());
        productRequestDTO.setPrice(product.getPrice());
        productRequestDTO.setStock(product.getStock());
        productRequestDTO.setImgReference(product.getImgReference());
        productRequestDTO.setStatus(product.getStatus());
        productRequestDTO.setCreateAt(product.getCreateAt());

        return productRequestDTO;
    }

    @Override
    public ProductEntity DTOToModel(ProductRequestDTO productRequestDTO) {
        ProductEntity product = new ProductEntity();
        if (productRequestDTO.getId() != null) {
            product.setId(productRequestDTO.getId());
        }
        product.setCode(productRequestDTO.getCode());
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        if (productRequestDTO.getCategory() != null) {
            product.setCategory(iCategoryService.findCategoryById(productRequestDTO.getCategory()));
        } else {
            product.setCategory(null);
        }
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());
        product.setImgReference(productRequestDTO.getImgReference());
        product.setStatus(productRequestDTO.getStatus());
        product.setCreateAt(productRequestDTO.getCreateAt());

        return product;

    }
}
