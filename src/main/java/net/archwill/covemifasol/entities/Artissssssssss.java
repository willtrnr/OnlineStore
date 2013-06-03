package net.archwill.covemifasol.entities;

public class Artissssssssss extends Entity {
  public Artissssssssss() {
    super(); //> implying
  }

  // id INTEGER NOT NULL,
  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
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
