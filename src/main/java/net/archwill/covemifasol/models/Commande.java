package net.archwill.covemifasol.models;

import java.util.Date;

public class Commande extends Model {
  public Commande() {
    super();
  }

  // id INTEGER NOT NULL,
  private int id;
  public void setId(int id) {
    this.id = id;
  }
  public int getId() {
    return id;
  }

  // client INTEGER,
  private int client;
  public void setClient(int client) {
    this.client = client;
  }
  public int getClient() {
    return client;
  }

  // tstamp DATE NOT NULL,
  private Date tStamp;
  public void setTStamp(Date tStamp) {
    this.tStamp = tStamp;
  }
  public Date getTStamp() {
    return tStamp;
  }

  // pst NUMBER(38, 2),
  private double pst;
  public void setPst(double pst) {
    this.pst = pst;
  }
  public double getPst() {
    return pst;
  }

  // gst NUMBER(38, 2),
  private double gst;
  public void setGst(double gst) {
    this.gst = gst;
  }
  public double getGst() {
    return gst;
  }

  // total NUMBER(38, 2) NOT NULL,
  private double total;
  public void setTotal(double total) {
    this.total = total;
  }
  public double getTotal() {
    return total;
  }
}
