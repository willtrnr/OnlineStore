package net.archwill.covemifasol.entities;

import java.sql.ResultSet;

public class Genre extends Entity {
  public Genre() {
    super();
  }

  public Genre(ResultSet rs) throws Exception {
    super();
    setId(rs.getInt(1));
    setItemType(rs.getInt(2));
    setNom(rs.getString(3));
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

  // nom VARCHAR2(50) NOT NULL,
  private String nom;
  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
}
