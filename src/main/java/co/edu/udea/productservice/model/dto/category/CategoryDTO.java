package co.edu.udea.productservice.model.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private Long id;
    @NotNull(message = "Codigo no debe ser nulo")
    private String code;
    @NotEmpty(message = "Nombre no debe ser vacío")
    private String name;
    private String status;
    private Date createAt;

    private static final long serialVersionUID = -2689042787235982608L;

}
