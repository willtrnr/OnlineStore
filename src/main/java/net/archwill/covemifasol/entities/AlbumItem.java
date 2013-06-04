package net.archwill.covemifasol.entities;

import java.sql.ResultSet;

public class AlbumItem extends Item {
  public AlbumItem() {
    super();
    setItemType(1);
  }

  public AlbumItem(ResultSet rs) throws Exception {
    super(rs);
    setArtissssssssss(rs.getInt(9));
  }

  // artiste INTEGER,
  private int artissssssssss;
  public int getArtissssssssss() {
    return artissssssssss;
  }
  public void setArtissssssssss(int artissssssssss) {
    this.artissssssssss = artissssssssss;
  }
}
