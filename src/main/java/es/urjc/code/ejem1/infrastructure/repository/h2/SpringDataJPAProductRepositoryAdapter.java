package es.urjc.code.ejem1.infrastructure.repository.h2;

import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.response.FullProductDTO;
import es.urjc.code.ejem1.infrastructure.exception.ProductNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Adapta a utilizar la tecnología necesaria.
// Si usamos Mongo pues tendremos un Adapter de Mongo que implementará un repository de mongo.
@Primary
@Component
public class SpringDataJPAProductRepositoryAdapter implements ProductRepository {

  private final SpringDataJPAProductRepository repository;
  private final ModelMapper mapper = new ModelMapper();

  public SpringDataJPAProductRepositoryAdapter(SpringDataJPAProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<FullProductDTO> finAll() {
    return Arrays.asList(mapper.map(repository.findAll(), FullProductDTO[].class));
  }

  @Override
  public FullProductDTO findById(Long id) {
    return mapper.map(repository.findById(id).orElseThrow(ProductNotFoundException::new),
        FullProductDTO.class);
  }

  @Override
  public FullProductDTO save(FullProductDTO product) {
    ProductEntity productEntity = mapper.map(product, ProductEntity.class);
    repository.save(productEntity);

    return mapper.map(productEntity, FullProductDTO.class);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}
