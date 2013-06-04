package net.archwill.covemifasol.entities;

import java.sql.ResultSet;

public class BookItem extends Item {
  public BookItem() {
    super();
    setItemType(3);
  }

  public BookItem(ResultSet rs) throws Exception {
    super(rs);
    setAuteur(rs.getInt(9));
  }

  // auteur INTEGER,
  private int auteur;
  public int getAuteur() {
    return auteur;
  }
  public void setAuteur(int auteur) {
    this.auteur = auteur;
  }
}
