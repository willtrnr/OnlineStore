package net.archwill.covemifasol.entities;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.archwill.covemifasol.DbManager;

public class Item extends Entity {
  public Item() {
    super();
    setTitre("Untitled");
    setPrix(1);
    setStock(0);
    setStockLimit(0);
  }

  public Item(ResultSet rs) throws Exception {
    super();
    setId(rs.getInt(1));
    setItemType(rs.getInt(2));
    setTitre(rs.getString(3));
    setPrix(rs.getDouble(4));
    setStock(rs.getInt(5));
    setStockLimit(rs.getInt(6));
    setGenre(rs.getInt(7));
    //setDate(rs.getDate(8)); or whatever it is
  }

  // id INTEGER NOT NULL,
  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  // itemtype SMALLINT NOT NULL,
  private int itemType;
  public int getItemType() {
    return itemType;
  }
  public void setItemType(int itemType) {
    this.itemType = itemType;
  }

  // titre VARCHAR2(50) NOT NULL,
  private String titre;
  public String getTitre() {
    return titre;
  }
  public void setTitre(String titre) {
    this.titre = titre;
  }

  // prix NUMBER(38, 2) NOT NULL,
  private double prix;
  public double getPrix() {
    return prix;
  }
  public void setPrix(double prix) {
    this.prix = prix;
  }

  // stock INTEGER,
  private int stock;
  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }

  // stocklimit INTEGER,
  private int stockLimit;
  public int getStockLimit() {
    return stockLimit;
  }
  public void setStockLimit(int stockLimit) {
    this.stockLimit = stockLimit;
  }

  // genre INTEGER,
  private int genre;
  public int getGenre() {
    return genre;
  }
  public void setGenre(int genre) {
    this.genre = genre;
  }
}
