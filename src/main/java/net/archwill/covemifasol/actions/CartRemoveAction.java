package net.archwill.covemifasol.actions;

import java.util.Map;
import net.archwill.covemifasol.entities.CartEntry;

public class CartRemoveAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (id != 0 && session != null) {
      Map<Integer, CartEntry> cart = (Map<Integer, CartEntry>)session.get("cart");
      cart.remove(id);
    }
    return SUCCESS;
  }

  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
