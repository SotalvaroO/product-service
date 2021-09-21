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
    @NotNull(message = "Codigo no debe ser nulo")
    private String code;
    @NotEmpty(message = "Nombre no debe ser vacío")
    private String name;
    @NotEmpty(message = "Descripcion no debe ser vacío")
    private String description;
    @NotNull(message = "Categoria no debe ser nulo")
    private Long category;
    @Positive(message = "El precio debe ser mayor que cero")
    private Double price;
    private String status;
    private Date createAt;

    private static final long serialVersionUID = 8428390992758933961L;
}
