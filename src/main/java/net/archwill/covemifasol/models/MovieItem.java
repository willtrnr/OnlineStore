package net.archwill.covemifasol.models;

public class MovieItem extends Item {
  public MovieItem() {
    super();
  }

  // item INTEGER NOT NULL,
  private int id;
  public void setId(int id) {
    this.id = id;
  }
  public int getId() {
    return id;
  }

  // realisateur INTEGER,
  private String realisateur;
  public void setRealisateur(String realisateur) {
    this.realisateur = realisateur;
  }
  public String getRealisateur() {
    return realisateur;
  }
}
