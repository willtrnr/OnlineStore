package net.archwill.covemifasol.actions;

import java.util.Map;
import net.archwill.covemifasol.entities.CartEntry;

public class CartAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (session != null && session.containsKey("cart")) {
      Map<Integer, CartEntry> cart = (Map<Integer, CartEntry>)session.get("cart");
      double total = 0;
      for (CartEntry entry : cart.values()) {
        if (entry.getItem() != null) {
          entry.setItem(entry.getItem().getId());
          total += entry.getItem().getPrix() * entry.getQte();
        }
      }
      double pst = total * 0.09975;
      total += pst;
      double gst = total * 0.05;
      locals.put("pst", pst);
      locals.put("gst", gst);
      locals.put("total", total);
    }
    return SUCCESS;
  }
}
