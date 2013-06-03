package net.archwill.covemifasol.entities;

public class BookItem extends Item {
  public BookItem() {
    super();
  }

  // item INTEGER NOT NULL,
  private int item;
  public void setItem(int item) {
    this.item = item;
  }
  public int getItem() {
    return item;
  }

  // auteur INTEGER,
  private int auteur;
  public void setAuteur(int auteur) {
    this.auteur = auteur;
  }
  public int getAuteur() {
    return auteur;
  }
}
