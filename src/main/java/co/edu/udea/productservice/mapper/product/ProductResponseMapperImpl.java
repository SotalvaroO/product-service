package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.mapper.category.ICategoryMapper;
import co.edu.udea.productservice.model.dto.product.ProductResponseDTO;
import co.edu.udea.productservice.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapperImpl implements IProductResponseMapper {

    @Autowired
    private ICategoryMapper iCategoryMapper;

    @Override
    public ProductResponseDTO modelToDTO(ProductEntity product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        if (product.getId() != null) {
            productResponseDTO.setId(product.getId());
        }
        productResponseDTO.setCode(product.getCode());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCategory(iCategoryMapper.modelToDTO(product.getCategory()));
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStatus(product.getStatus());
        productResponseDTO.setCreateAt(product.getCreateAt());

        return productResponseDTO;
    }

    @Override
    public ProductEntity DTOToModel(ProductResponseDTO productResponseDTO) {
        ProductEntity product = new ProductEntity();
        if (productResponseDTO.getId() != null){
            product.setId(productResponseDTO.getId());
        }
        product.setCode(productResponseDTO.getCode());
        product.setName(productResponseDTO.getName());
        product.setDescription(productResponseDTO.getDescription());
        product.setCategory(iCategoryMapper.DTOToModel(productResponseDTO.getCategory()));
        product.setPrice(productResponseDTO.getPrice());
        product.setStatus(productResponseDTO.getStatus());
        product.setCreateAt(productResponseDTO.getCreateAt());

        return product;
    }
}
