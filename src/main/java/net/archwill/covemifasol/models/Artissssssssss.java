package net.archwill.covemifasol.models;

public class Artissssssssss extends Model {
  public Artissssssssss() {
    super(); //> implying
  }

  // id INTEGER NOT NULL,
  private int id;
  public void setId(int id) {
    this.id = id;
  }
  public int getId() {
    return id;
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
