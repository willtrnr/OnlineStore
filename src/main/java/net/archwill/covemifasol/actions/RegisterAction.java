package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.Client;

public class RegisterAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (client != null && confirm != null && confirm.equals(client.getPassword())) {
      client.setPassword(Client.hashPassword(client.getPassword()));
      if (DbManager.Instance().save(client)) {
        return SUCCESS;
      }
    }
    return INPUT;
  }

  private Client client;
  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
    locals.put("client", client);
  }

  private String confirm;
  public String getConfirm() {
    return confirm;
  }
  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }
}
