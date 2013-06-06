package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;

public class IndexAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    locals.put("books", DbManager.Instance().findAllBooks());
    locals.put("movies", DbManager.Instance().findAllMovies());
    locals.put("albums", DbManager.Instance().findAllAlbums());
    return SUCCESS;
  }
}
