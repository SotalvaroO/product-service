package co.edu.udea.productservice.mapper.product;

import co.edu.udea.productservice.model.dto.category.CategoryDTO;
import co.edu.udea.productservice.model.dto.product.ProductResponseDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import co.edu.udea.productservice.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListProductResponseMapper implements IListProductResponseMapper {

    @Autowired
    private IProductResponseMapper iProductResponseMapper;

    @Override
    public List<ProductResponseDTO> modelToDTO(List<ProductEntity> products) {
        List<ProductResponseDTO> responsesDTO = new ArrayList<>();
        for (ProductEntity pe : products
        ) {
            responsesDTO.add(iProductResponseMapper.modelToDTO(pe));
        }

        return responsesDTO;
    }
}
