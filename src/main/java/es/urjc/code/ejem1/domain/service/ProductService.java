package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.request.ProductDTO;
import es.urjc.code.ejem1.domain.response.FullProductDTO;
import java.util.Collection;

public interface ProductService {

  Collection<FullProductDTO> getProducts();

  FullProductDTO getProduct(Long id);

  FullProductDTO createProduct(ProductDTO productDTO);

  FullProductDTO deleteProduct(Long id);
}
