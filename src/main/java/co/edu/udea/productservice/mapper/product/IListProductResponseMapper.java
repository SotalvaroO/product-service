package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.model.dto.category.CategoryDTO;
import co.edu.udea.productservice.model.dto.product.ProductResponseDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.model.entity.ProductEntity;

import java.util.List;

public interface IListProductResponseMapper {

    List<ProductResponseDTO> modelToDTO(List<ProductEntity> products);

}
