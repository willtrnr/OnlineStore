package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.Item;

public class ItemAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    Item item = DbManager.Instance().findItemById(id);
    if (item != null) {
      locals.put("item", item);
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
