package es.urjc.code.ejem1.infrastructure.repository.h2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

}
