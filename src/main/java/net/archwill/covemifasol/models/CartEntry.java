package net.archwill.covemifasol.models;

public class CartEntry extends Model {
  public CartEntry() {
    super();
  }

  // client INTEGER,
  private int client;
  public void setClient(int client) {
    this.client = client;
  }
  public int getClient() {
    return client;
  }

  // sessid VARCHAR2(32),
  private String sessId;
  public void setSessId(String sessId) {
    this.sessId = sessId;
  }
  public String getSessId() {
    return sessId;
  }

  // item INTEGER NOT NULL,
  private int item;
  public void setItem(int item) {
    this.item = item;
  }
  public int getItem() {
    return item;
  }

  // qte INTEGER NOT NULL,
  private int qte;
  public void setQte(int qte) {
    this.qte = qte;
  }
  public int getQte() {
    return qte;
  }
}
