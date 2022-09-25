package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.FullProductDTO;
import es.urjc.code.ejem1.domain.ProductDTO;
import java.util.Collection;

public interface ProductService {
	public Collection<FullProductDTO> getProducts();
	public FullProductDTO getProduct(Long id);
	public FullProductDTO createProduct(ProductDTO productDTO);
	public FullProductDTO deleteProduct(Long id);
}
