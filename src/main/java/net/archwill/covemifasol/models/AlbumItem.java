package net.archwill.covemifasol.models;

public class AlbumItem extends Item {
  public AlbumItem() {
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

  // artiste INTEGER,
  private int artissssssssss;
  public void setArtissssssssss(int artissssssssss) {
    this.artissssssssss = artissssssssss;
  }
  public int getArtissssssssss() {
    return artissssssssss;
  }
}
