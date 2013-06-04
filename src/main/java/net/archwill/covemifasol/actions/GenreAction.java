package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.Genre;

public class GenreAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    Genre genre = DbManager.Instance().findGenreById(id);
    if (genre != null) {
      locals.put("sectiontitle", genre.getNom());
      if (genre.getItemType() == 3) {
        locals.put("genres", DbManager.Instance().findBookGenres());
        locals.put("items", DbManager.Instance().findBooksByGenre(id));
      } else if (genre.getItemType() == 2) {
        locals.put("genres", DbManager.Instance().findMovieGenres());
        locals.put("items", DbManager.Instance().findMoviesByGenre(id));
      } else if (genre.getItemType() == 1) {
        locals.put("genres", DbManager.Instance().findAlbumGenres());
        locals.put("items", DbManager.Instance().findAlbumsByGenre(id));
      } else {
        locals.put("genres", DbManager.Instance().findAllGenres());
        locals.put("items", DbManager.Instance().findItemsByGenre(id));
      }
      return SUCCESS;
    } else {
      return ERROR;
    }
  }

  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
