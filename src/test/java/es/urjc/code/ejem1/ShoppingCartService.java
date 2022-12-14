package es.urjc.code.ejem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import es.urjc.code.ejem1.domain.response.FullProductDTO;
import es.urjc.code.ejem1.domain.response.FullShoppingCartDTO;
import es.urjc.code.ejem1.domain.response.FullShoppingCartItemDTO;
import es.urjc.code.ejem1.domain.Product;
import es.urjc.code.ejem1.domain.request.ProductDTO;
import es.urjc.code.ejem1.domain.repository.ProductRepository;
import es.urjc.code.ejem1.domain.service.ProductServiceImpl;
import es.urjc.code.ejem1.domain.repository.ShoppingCartRepository;
import es.urjc.code.ejem1.domain.service.ShoppingCartServiceImpl;
import es.urjc.code.ejem1.service.ValidationServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartService {
	
	private ProductRepository productRepository;
	private ProductServiceImpl productService;

	private ShoppingCartRepository shoppingCartRepository;
	private ShoppingCartServiceImpl shoppingCartService;

	private ModelMapper mapper = new ModelMapper();
	
	private static FullShoppingCartDTO createdShoppingCart;
	
	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		shoppingCartRepository = mock(ShoppingCartRepository.class);
		
		productService = new ProductServiceImpl(productRepository);
		shoppingCartService = new ShoppingCartServiceImpl(
				shoppingCartRepository,
		        productRepository,
		        new ValidationServiceImpl());
	}
	
	@Test
	@Order(1)
	void shoppingCartCanBeAdded() {
		createdShoppingCart = shoppingCartService.createShoppingCart();
		verify(shoppingCartRepository).save(createdShoppingCart);
	}
	
	@Test
	@Order(2)
	void productCanBeAddedToShoppingCart() {
		Long id = 1L;
		Product product = new Product(
		        "PLUM??FERO MONTA??A Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plum??n y plumas, con certificado RDS, abriga bien durante un vivac entre +5 ??C y -5 ??C.",
		        49.99);
		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		FullProductDTO fullProductDTO = productService.createProduct(productDTO);
		verify(productRepository).save(fullProductDTO);
		
		int items = Math.abs(new Random().nextInt());

		// Ids, after creation.
		fullProductDTO.setId(id);
		createdShoppingCart.setId(id);

		Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(fullProductDTO);
		Mockito.when(shoppingCartRepository.findById(Mockito.anyLong())).thenReturn(createdShoppingCart);

		createdShoppingCart = shoppingCartService.addProduct(fullProductDTO.getId(), createdShoppingCart.getId(), items);
		FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);

		assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
		assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * productDTO.getPrice());
	}
	
	@Test
	@Order(3)
	void shoppingCartCanBeDeleted() {
		shoppingCartService.deleteShoppingCart(createdShoppingCart.getId());
		verify(shoppingCartRepository).deleteById(createdShoppingCart.getId());
	}
}
