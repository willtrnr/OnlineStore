package net.archwill.covemifasol.entities;

import net.archwill.covemifasol.DbManager;

public class CartEntry extends Entity {
  public CartEntry() {
    super();
    setQte(1);
  }

  // client INTEGER,
  private int client;
  public int getClient() {
    return client;
  }
  public void setClient(int client) {
    this.client = client;
  }

  // sessid VARCHAR2(32),
  private String sessId;
  public String getSessId() {
    return sessId;
  }
  public void setSessId(String sessId) {
    this.sessId = sessId;
  }

  // item INTEGER NOT NULL,
  private Item item;
  public Item getItem() {
    return item;
  }
  public void setItem(Item item) {
    this.item = item;
  }
  public void setItem(int item) throws Exception {
    this.item = DbManager.Instance().findItemById(item);
  }

  // qte INTEGER NOT NULL,
  private int qte;
  public int getQte() {
    return qte;
  }
  public void setQte(int qte) {
    this.qte = qte;
  }
}
