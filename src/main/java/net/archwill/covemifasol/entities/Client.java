package net.archwill.covemifasol.entities;

public class Client extends Entity {
  public Client() {
    super();
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

  // prenom VARCHAR2(50) NOT NULL,
  private String prenom;
  public String getPrenom() {
    return prenom;
  }
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  // addresse VARCHAR2(255),
  private String addresse;
  public String getAddresse() {
    return addresse;
  }
  public void setAddresse(String addresse) {
    this.addresse = addresse;
  }

  // ville VARCHAR2(50),
  private String ville;
  public String getVille() {
    return ville;
  }
  public void setVille(String ville) {
    this.ville = ville;
  }

  // ccnumber VARCHAR2(16),
  private String ccNumber;
  public String getCcNumber() {
    return ccNumber;
  }
  public void setCcNumber(String ccNumber) {
    this.ccNumber = ccNumber;
  }

  // ccmonth SMALLINT,
  private int ccMonth;
  public int getCcMonth() {
    return ccMonth;
  }
  public void setCcMonth(int ccMonth) {
    this.ccMonth = ccMonth;
  }

  // ccyear SMALLINT,
  private int ccYear;
  public int getCcYear() {
    return ccYear;
  }
  public void setCcYear(int ccYear) {
    this.ccYear = ccYear;
  }

  // cctype VARCHAR2(10),
  private String ccType;
  public String getCcType() {
    return ccType;
  }
  public void setCcType(String ccType) {
    this.ccType = ccType;
  }
}
