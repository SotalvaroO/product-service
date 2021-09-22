package co.edu.udea.productservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_products")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @NotEmpty(message = "Nombre no debe ser vacío")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull(message = "Categoria no debe ser vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Positive(message = "El precio debe ser mayor que cero")
    @Column(name = "price")
    private Double price;

    @Positive(message = "El stock debe ser mayor que cero")
    @Column(name = "stock")
    private Double stock;

    @Column(name = "img_reference")
    private String imgReference;

    @Column(name = "status")
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    private static final long serialVersionUID = 7708595151233242893L;

}
