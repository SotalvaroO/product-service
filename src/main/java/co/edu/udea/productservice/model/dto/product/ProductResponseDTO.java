package co.edu.udea.productservice.model.dto.product;

import co.edu.udea.productservice.model.dto.category.CategoryDTO;
import co.edu.udea.productservice.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDTO implements Serializable {

    private Long id;
    private String code;
    private String name;
    private String description;
    private CategoryDTO category;
    private Double price;
    private Double stock;
    private String imgReference;
    private String status;
    private Date createAt;

    private static final long serialVersionUID = 6679721988254470908L;
}
