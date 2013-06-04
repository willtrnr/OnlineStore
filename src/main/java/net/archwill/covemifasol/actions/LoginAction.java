package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;

public class LoginAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (email != null && password != null) {

    }
    return SUCCESS;
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
