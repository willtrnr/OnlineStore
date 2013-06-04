package net.archwill.covemifasol.actions;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import net.archwill.covemifasol.DbManager;

public class IndexAction extends Action {
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);

  @Override
  public String execute() throws Exception {
    super.execute();
    locals.put("books", DbManager.Instance().findAllBooks());
    locals.put("movies", DbManager.Instance().findAllMovies());
    locals.put("albums", DbManager.Instance().findAllAlbums());
    return SUCCESS;
  }
}
