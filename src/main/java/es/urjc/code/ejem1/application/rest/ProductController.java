package es.urjc.code.ejem1.application.rest;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.urjc.code.ejem1.application.request.ProductRequestDTO;
import es.urjc.code.ejem1.application.response.ProductResponseDTO;
import es.urjc.code.ejem1.domain.request.ProductDTO;
import es.urjc.code.ejem1.domain.response.FullProductDTO;
import es.urjc.code.ejem1.domain.service.ProductService;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;
  private final ModelMapper mapper = new ModelMapper();

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public Collection<ProductResponseDTO> getProducts() {
    return Arrays.asList(mapper.map(productService.getProducts(), ProductResponseDTO[].class));
  }

  @GetMapping("/{id}")
  public ProductResponseDTO getProduct(@PathVariable Long id) {
    return mapper.map(productService.getProduct(id), ProductResponseDTO.class);
  }

  @PostMapping
  public ResponseEntity<ProductResponseDTO> createProduct(
      @RequestBody ProductRequestDTO productRequestDTO) {
    ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
    FullProductDTO fullProductDTO = productService.createProduct(productDTO);

    URI location = fromCurrentRequest().path("/{id}")
        .buildAndExpand(fullProductDTO.getId()).toUri();

    return ResponseEntity.created(location).body(
        mapper.map(fullProductDTO, ProductResponseDTO.class));
  }

  @DeleteMapping("/{id}")
  public ProductResponseDTO deleteProduct(@PathVariable Long id) {
    return mapper.map(productService.deleteProduct(id), ProductResponseDTO.class);
  }

}
