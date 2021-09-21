package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.model.dto.product.ProductRequestDTO;
import co.edu.udea.productservice.model.dto.product.ProductResponseDTO;
import co.edu.udea.productservice.model.entity.ProductEntity;

public interface IProductResponseMapper {

    ProductResponseDTO modelToDTO(ProductEntity product);
    ProductEntity DTOToModel(ProductResponseDTO productResponseDTO);

}
