package net.archwill.covemifasol.entities;

public class CommandeEntry extends Entity {
  public CommandeEntry() {
    super();
  }

  // commande INTEGER NOT NULL,
  private int commande;
  public int getCommande() {
    return commande;
  }
  public void setCommande(int commande) {
    this.commande = commande;
  }

  // item INTEGER NOT NULL,
  private int item;
  public int getItem() {
    return item;
  }
  public void setItem(int item) {
    this.item = item;
  }

  // prix NUMBER(38, 2) NOT NULL,
  private double prix;
  public double getPrix() {
    return prix;
  }
  public void setPrix(double prix) {
    this.prix = prix;
  }

  // qte INTEGER NOT NULL,
  private int qte;
  public int getQte() {
    return qte;
  }
  public void setQte(int qte) {
    this.qte = qte;
  }
}
