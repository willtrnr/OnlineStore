package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.Client;

public class LoginAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (email != null && password != null) {
      Client client = DbManager.Instance().findClientByLogin(email, password);
      if (client != null) {
        session.put("userid", client.getId());
        return SUCCESS;
      }
    }
    return INPUT;
  }

  private String email;
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  private String password;
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
