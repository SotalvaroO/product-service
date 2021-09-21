package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.model.dto.product.ProductRequestDTO;
import co.edu.udea.productservice.model.entity.ProductEntity;

public interface IProductRequestMapper {

    ProductRequestDTO modelToDTO(ProductEntity product);

    ProductEntity DTOToModel(ProductRequestDTO productRequestDTO);

}
