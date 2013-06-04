package net.archwill.covemifasol.entities;

import java.sql.ResultSet;

public class MovieItem extends Item {
  public MovieItem() {
    super();
    setItemType(2);
  }

  public MovieItem(ResultSet rs) throws Exception {
    super(rs);
    setRealisateur(rs.getInt(9));
  }

  // realisateur INTEGER,
  private int realisateur;
  public int getRealisateur() {
    return realisateur;
  }
  public void setRealisateur(int realisateur) {
    this.realisateur = realisateur;
  }
}
