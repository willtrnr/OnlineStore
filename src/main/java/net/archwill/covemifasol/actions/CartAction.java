package net.archwill.covemifasol.actions;

import java.util.Map;
import net.archwill.covemifasol.entities.CartEntry;

public class CartAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (session != null && session.containsKey("cart")) {
      Map<Integer, CartEntry> cart = (Map<Integer, CartEntry>)session.get("cart");
      for (CartEntry entry : cart.values()) {
        if (entry.getItem() != null) {
          entry.setItem(entry.getItem().getId());
        }
      }
    }
    return SUCCESS;
  }
}
