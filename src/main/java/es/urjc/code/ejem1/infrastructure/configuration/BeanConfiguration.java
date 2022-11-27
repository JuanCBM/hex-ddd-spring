package es.urjc.code.ejem1.infrastructure.configuration;

import es.urjc.code.ejem1.domain.service.ProductService;
import es.urjc.code.ejem1.domain.service.ProductServiceImpl;
import es.urjc.code.ejem1.domain.service.ShoppingCartService;
import es.urjc.code.ejem1.domain.service.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.infrastructure.repository.h2.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.ejem1.infrastructure.repository.h2.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.ejem1.service.ValidationServiceImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class BeanConfiguration {

  @Bean
  public ShoppingCartService shoppingCartService(
      SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
      SpringDataJPAProductRepositoryAdapter productRepositoryAdapter) {
    return new ShoppingCartServiceImpl(
        shoppingCartRepositoryAdapter,
        productRepositoryAdapter,
        new ValidationServiceImpl());
  }

  @Bean
  public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
    return new ProductServiceImpl(repositoryAdapter);
  }

}
