package net.archwill.covemifasol.actions;

public class LogoutAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (session != null && session.containsKey("userid")) {
      session.remove("userid");
    }
    return SUCCESS;
  }
}
