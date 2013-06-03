package net.archwill.covemifasol.entities;

public class Item extends Entity {
  public Item() {
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

  // itemtype SMALLINT NOT NULL,
  private int itemType;
  public void setItemType(int itemType) {
    this.itemType = itemType;
  }
  public int getItemType() {
    return itemType;
  }

  // titre VARCHAR2(50) NOT NULL,
  private String titre;
  public void setTitre(String titre) {
    this.titre = titre;
  }
  public String getTitre() {
    return titre;
  }

  // prix NUMBER(38, 2) NOT NULL,
  private double prix;
  public void setPrix(double prix) {
    this.prix = prix;
  }
  public double getPrix() {
    return prix;
  }

  // stock INTEGER,
  private int stock;
  public void setStock(int stock) {
    this.stock = stock;
  }
  public int getStock() {
    return stock;
  }

  // stocklimit INTEGER,
  private int stockLimit;
  public void setStockLimit(int stockLimit) {
    this.stockLimit = stockLimit;
  }
  public int getStockLimit() {
    return stockLimit;
  }

  // genre INTEGER,
  private int genre;
  public void setGenre(int genre) {
    this.genre = genre;
  }
  public int getGenre() {
    return genre;
  }
}
