package net.archwill.covemifasol.entities;

public class Client extends Entity {
  public Client() {
    super();
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

  // prenom VARCHAR2(50) NOT NULL,
  private String prenom;
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  public String getPrenom() {
    return prenom;
  }

  // addresse VARCHAR2(255),
  private String addresse;
  public void setAddresse(String addresse) {
    this.addresse = addresse;
  }
  public String getAddresse() {
    return addresse;
  }

  // ville VARCHAR2(50),
  private String ville;
  public void setVille(String ville) {
    this.ville = ville;
  }
  public String getVille() {
    return ville;
  }

  // ccnumber VARCHAR2(16),
  private String ccNumber;
  public void setCcNumber(String ccNumber) {
    this.ccNumber = ccNumber;
  }
  public String getCcNumber() {
    return ccNumber;
  }

  // ccmonth SMALLINT,
  private int ccMonth;
  public void setCcMonth(int ccMonth) {
    this.ccMonth = ccMonth;
  }
  public int getCcMonth() {
    return ccMonth;
  }

  // ccyear SMALLINT,
  private int ccYear;
  public void setCcYear(int ccYear) {
    this.ccYear = ccYear;
  }
  public int getCcYear() {
    return ccYear;
  }

  // cctype VARCHAR2(10),
  private String ccType;
  public void setCcType(String ccType) {
    this.ccType = ccType;
  }
  public String getCcType() {
    return ccType;
  }
}
