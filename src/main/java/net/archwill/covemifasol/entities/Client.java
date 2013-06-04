package net.archwill.covemifasol.entities;

import java.security.MessageDigest;
import java.sql.ResultSet;

public class Client extends Entity {
  public Client() {
    super();
  }

  public Client(ResultSet rs) throws Exception {
    super();
    setId(rs.getInt(1));
    setNom(rs.getString(2));
    setPrenom(rs.getString(3));
    setAddresse(rs.getString(4));
    setVille(rs.getString(5));
    setCcNumber(rs.getString(6));
    setCcMonth(rs.getInt(7));
    setCcYear(rs.getInt(8));
    setCcType(rs.getString(9));
    setEmail(rs.getString(10));
    setPassword(rs.getString(11));
  }

  public static String hashPassword(String password) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA-512");
    byte[] digest = md.digest(password.getBytes());
    StringBuilder hash = new StringBuilder();
    for (byte b : digest) {
      hash.append(String.format("%02x", b));
    }
    return hash.toString();
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

  // email VARCHAR2(50),
  private String email;
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  // password CHAR(128),
  private String password;
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
