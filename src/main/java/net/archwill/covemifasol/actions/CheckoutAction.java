package net.archwill.covemifasol.actions;

import java.util.Map;
import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.CartEntry;
import net.archwill.covemifasol.entities.Commande;

public class CheckoutAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (user == null) return LOGIN;
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

      if (confirm != null && confirm.equals("yes")) {
        Commande cmd = new Commande();
        cmd.setId(DbManager.Instance().nextOrderId());
        cmd.setClient(user.getId());
        cmd.setPst(pst);
        cmd.setGst(gst);
        cmd.setTotal(total);
        if (DbManager.Instance().save(cmd)) {
          for (CartEntry entry : cart.values()) {
            if (entry.getItem() != null) {
              DbManager.Instance().saveToOrder(cmd, entry);
            }
          }
          cart.clear();
          locals.put("order", cmd);
          return SUCCESS;
        }
      }
    }
    return INPUT;
  }

  private String confirm;
  public String getConfirm() {
    return confirm;
  }
  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }
}
