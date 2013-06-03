package net.archwill.covemifasol.entities;

public class MovieItem extends Item {
  public MovieItem() {
    super();
    setItemType(2);
  }

  // realisateur INTEGER,
  private String realisateur;
  public String getRealisateur() {
    return realisateur;
  }
  public void setRealisateur(String realisateur) {
    this.realisateur = realisateur;
  }
}
