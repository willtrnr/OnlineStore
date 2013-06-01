package net.archwill.covemifasol.actions;

public class IndexAction extends Action {
  @Override
  public String execute() throws Exception {
    return SUCCESS;
  }

  public void setTest(String test) {
    locals.put("test", test);
  }
}
