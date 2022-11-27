package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.request.ShoppingCartDTO;
import es.urjc.code.ejem1.domain.response.FullShoppingCartDTO;

public interface ShoppingCartService {

  FullShoppingCartDTO getShoppingCart(Long id);

  FullShoppingCartDTO createShoppingCart();

  FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

  FullShoppingCartDTO deleteShoppingCart(Long id);

  FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int nProducts);

  FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct);
}
