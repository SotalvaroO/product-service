package co.edu.udea.productservice.controller.product;

import co.edu.udea.productservice.mapper.product.IListProductResponseMapper;
import co.edu.udea.productservice.mapper.product.IProductRequestMapper;
import co.edu.udea.productservice.mapper.product.IProductResponseMapper;
import co.edu.udea.productservice.model.dto.category.CategoryDTO;
import co.edu.udea.productservice.model.dto.product.ProductRequestDTO;
import co.edu.udea.productservice.model.dto.product.ProductResponseDTO;
import co.edu.udea.productservice.model.entity.ProductEntity;
import co.edu.udea.productservice.service.category.ICategoryService;
import co.edu.udea.productservice.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductResponseMapper iProductResponseMapper;
    @Autowired
    private IProductRequestMapper iProductRequestMapper;
    @Autowired
    private IListProductResponseMapper iListProductResponseMapper;

    @GetMapping
    ResponseEntity<List<ProductResponseDTO>> listProductByCategory(@RequestParam(name = "categoryCode", required = false) String categoryCode) {

        List<ProductEntity> products = new ArrayList<>();
        if (categoryCode == null) {
            products = iProductService.listAllProduct();

            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            products = iProductService.listByProductCategory(iCategoryService.findCategoryByCode(categoryCode));
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        List<ProductResponseDTO> productResponseDTO = iListProductResponseMapper.modelToDTO(products);
        return ResponseEntity.ok(productResponseDTO);

    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = iProductService.createProduct(iProductRequestMapper.DTOToModel(productRequestDTO));
        ProductResponseDTO productResponseDTO = iProductResponseMapper.modelToDTO(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO);
    }

    @PutMapping(value = "/{code}")
    public ResponseEntity<ProductResponseDTO> updatetProduct(@PathVariable("code") String code, @RequestBody ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = iProductService.findProductByCode(code);
        if (productEntity == null) {
            return ResponseEntity.notFound().build();
        }
        productRequestDTO.setId(productEntity.getId());
        productRequestDTO.setCode(productEntity.getCode());
        ProductEntity productEntityDB = iProductService.updateProduct(iProductRequestMapper.DTOToModel(productRequestDTO));
        return ResponseEntity.ok(iProductResponseMapper.modelToDTO(productEntityDB));

    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable("code") String code){
        ProductEntity productEntity = iProductService.findProductByCode(code);
        if (productEntity == null){
            ResponseEntity.notFound().build();
        }
        ProductResponseDTO productResponseDTO = iProductResponseMapper.modelToDTO(iProductService.deleteProductById(productEntity.getId()));
        return ResponseEntity.ok(productResponseDTO);
    }


}
