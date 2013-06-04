package net.archwill.covemifasol.actions;

import java.util.Map;
import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.CartEntry;

public class CartAddAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (id != 0 && session != null) {
      Map<Integer, CartEntry> cart = (Map<Integer, CartEntry>)session.get("cart");
      if (!cart.containsKey(id)) {
        CartEntry entry = new CartEntry();
        entry.setItem(id);
        entry.setQte(0);
        if (session.containsKey("userid")) {
          entry.setClient((Integer)session.get("userid"));
        }
        cart.put(id, entry);
      }
      cart.get(id).setQte(cart.get(id).getQte() + 1);
      return SUCCESS;
    } else {
      return ERROR;
    }
  }

  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
