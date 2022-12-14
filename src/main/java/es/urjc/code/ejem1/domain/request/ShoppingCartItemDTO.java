package es.urjc.code.ejem1.domain.request;

import es.urjc.code.ejem1.domain.Product;

public class ShoppingCartItemDTO {

  private Product product;
  private int quantity;
  private double totalPrice;

  public ShoppingCartItemDTO() {
    super();
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

}
