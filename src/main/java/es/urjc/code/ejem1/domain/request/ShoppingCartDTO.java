package es.urjc.code.ejem1.domain.request;

import es.urjc.code.ejem1.domain.ShoppingCartStatus;
import java.util.List;

public class ShoppingCartDTO {

  private ShoppingCartStatus status;
  private List<ShoppingCartItemDTO> items;
  private double price;

  public ShoppingCartDTO() {
    super();
  }

  public ShoppingCartStatus getStatus() {
    return status;
  }

  public void setStatus(ShoppingCartStatus status) {
    this.status = status;
  }

  public List<ShoppingCartItemDTO> getItems() {
    return items;
  }

  public void setItems(List<ShoppingCartItemDTO> items) {
    this.items = items;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
