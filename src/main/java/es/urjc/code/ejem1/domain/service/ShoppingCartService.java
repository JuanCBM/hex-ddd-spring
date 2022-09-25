package es.urjc.code.ejem1.domain.service;

import es.urjc.code.ejem1.domain.FullProductDTO;
import es.urjc.code.ejem1.domain.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.ShoppingCartDTO;

public interface ShoppingCartService {
	public FullShoppingCartDTO getShoppingCart(Long id);

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(Long id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(Long id);

	public FullShoppingCartDTO addProduct(Long idShoppingCart, Long idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity);

	public FullShoppingCartDTO deleteProduct(Long idShoppingCart, Long idProduct);
}
