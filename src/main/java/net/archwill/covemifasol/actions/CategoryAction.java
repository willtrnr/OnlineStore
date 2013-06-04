package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;

public class CategoryAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (cat == 1) {
      locals.put("sectiontitle", "Books");
      locals.put("genres", DbManager.Instance().findBookGenres());
      locals.put("items", DbManager.Instance().findAllBooks());
    } else if (cat == 2) {
      locals.put("sectiontitle", "Movies");
      locals.put("genres", DbManager.Instance().findMovieGenres());
      locals.put("items", DbManager.Instance().findAllMovies());
    } else if (cat == 3) {
      locals.put("sectiontitle", "Albums");
      locals.put("genres", DbManager.Instance().findAlbumGenres());
      locals.put("items", DbManager.Instance().findAllAlbums());
    } else {
      locals.put("sectiontitle", "Items");
      locals.put("genres", DbManager.Instance().findAllGenres());
      locals.put("items", DbManager.Instance().findAllItems());
    }
    return SUCCESS;
  }

  private int cat;
  public int getCat() {
    return cat;
  }
  public void setCat(int cat) {
    this.cat = cat;
    locals.put("cat", cat);
  }
}
