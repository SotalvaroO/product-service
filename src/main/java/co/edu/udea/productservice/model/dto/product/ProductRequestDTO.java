package co.edu.udea.productservice.model.dto.product;

import co.edu.udea.productservice.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDTO implements Serializable {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Long category;
    private Double price;
    private Double stock;
    private String imgReference;
    private String status;
    private Date createAt;

    private static final long serialVersionUID = 8428390992758933961L;
}
