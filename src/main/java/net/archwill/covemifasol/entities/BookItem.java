package net.archwill.covemifasol.entities;

public class BookItem extends Item {
  public BookItem() {
    super();
    setItemType(1);
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
