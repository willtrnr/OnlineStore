package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;

public class IndexAction extends Action {
  @Override
  public String execute() throws Exception {
    DbManager.Instance();
    return SUCCESS;
  }

  public void setTest(String test) {
    locals.put("test", test);
  }
}
