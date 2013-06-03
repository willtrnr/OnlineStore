package net.archwill.covemifasol.entities;

public class CartEntry extends Entity {
  public CartEntry() {
    super();
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
  private int item;
  public int getItem() {
    return item;
  }
  public void setItem(int item) {
    this.item = item;
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
