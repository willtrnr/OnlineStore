package net.archwill.covemifasol.entities;

import java.util.Date;

public class Commande extends Entity {
  public Commande() {
    super();
  }

  // id INTEGER NOT NULL,
  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  // client INTEGER,
  private int client;
  public int getClient() {
    return client;
  }
  public void setClient(int client) {
    this.client = client;
  }

  // tstamp DATE NOT NULL,
  private Date tStamp;
  public Date getTStamp() {
    return tStamp;
  }
  public void setTStamp(Date tStamp) {
    this.tStamp = tStamp;
  }

  // pst NUMBER(38, 2),
  private double pst;
  public double getPst() {
    return pst;
  }
  public void setPst(double pst) {
    this.pst = pst;
  }

  // gst NUMBER(38, 2),
  private double gst;
  public double getGst() {
    return gst;
  }
  public void setGst(double gst) {
    this.gst = gst;
  }

  // total NUMBER(38, 2) NOT NULL,
  private double total;
  public double getTotal() {
    return total;
  }
  public void setTotal(double total) {
    this.total = total;
  }
}
