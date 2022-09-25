package es.urjc.code.ejem1.infrastructure.repository.mongo;

import es.urjc.code.ejem1.domain.FullProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// TODO
@Component
public class MongoDBProductRepository implements ProductRepository {

  private final SpringDataMongoProductRepository productRepository;

  @Autowired
  public MongoDBProductRepository(final SpringDataMongoProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Collection<FullProductDTO> finAll() {
    return null;
  }

  @Override
  public FullProductDTO findById(Long id) {
    return null;
  }

  @Override
  public FullProductDTO save(FullProductDTO product) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }
}
