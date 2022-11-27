package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.request.ProductDTO;
import es.urjc.code.ejem1.domain.response.FullProductDTO;
import java.util.Collection;
import org.modelmapper.ModelMapper;

public class ProductServiceImpl implements ProductService {

  ModelMapper mapper = new ModelMapper();
  private final ProductRepository repository;

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<FullProductDTO> getProducts() {
    return repository.finAll();
  }

  @Override
  public FullProductDTO getProduct(Long id) {
    return repository.findById(id);
  }

  @Override
  public FullProductDTO createProduct(ProductDTO productDTO) {
    FullProductDTO fullProductDTO = mapper.map(productDTO, FullProductDTO.class);
    FullProductDTO saveFullProductDTO = repository.save(fullProductDTO);

    return (saveFullProductDTO != null) ? saveFullProductDTO : fullProductDTO;
  }

  @Override
  public FullProductDTO deleteProduct(Long id) {
    FullProductDTO product = repository.findById(id);
    repository.deleteById(id);

    return product;
  }

}
