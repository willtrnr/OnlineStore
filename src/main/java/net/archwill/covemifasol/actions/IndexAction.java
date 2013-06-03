package net.archwill.covemifasol.actions;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import net.archwill.covemifasol.entities.*;

public class IndexAction extends Action {
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);

  @Override
  public String execute() throws Exception {
    List<Item> books = new ArrayList<Item>();
    books.add(new BookItem());
    books.add(new BookItem());
    books.add(new BookItem());
    books.add(new BookItem());
    books.add(new BookItem());
    books.add(new BookItem());
    books.add(new BookItem());
    locals.put("books", books);

    List<Item> movies = new ArrayList<Item>();
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    movies.add(new MovieItem());
    locals.put("movies", movies);

    List<Item> albums = new ArrayList<Item>();
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    albums.add(new AlbumItem());
    locals.put("albums", albums);

    return SUCCESS;
  }

  public void setTest(String test) {

  }
}
