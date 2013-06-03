package net.archwill.covemifasol.models;

public class ItemCommande extends Model {
  public ItemCommande() {
    super();
  }

  // commande INTEGER NOT NULL,
  private int commande;
  public void setCommande(int commande) {
    this.commande = commande;
  }
  public int getCommande() {
    return commande;
  }

  // item INTEGER NOT NULL,
  private int item;
  public void setItem(int item) {
    this.item = item;
  }
  public int getItem() {
    return item;
  }

  // prix NUMBER(38, 2) NOT NULL,
  private double prix;
  public void setPrix(double prix) {
    this.prix = prix;
  }
  public double getPrix() {
    return prix;
  }

  // qte INTEGER NOT NULL,
  private int qte;
  public void setQte(int qte) {
    this.qte = qte;
  }
  public int getQte() {
    return qte;
  }
}
