package net.archwill.covemifasol.entities;

public class Genre extends Entity {
  public Genre() {
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

  // nom VARCHAR2(50) NOT NULL,
  private String nom;
  public void setNom(String nom) {
    this.nom = nom;
  }
  public String getNom() {
    return nom;
  }
}
