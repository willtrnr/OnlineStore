package net.archwill.covemifasol;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import net.archwill.covemifasol.entities.*;

public class DbManager {
  private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

  private static DbManager INSTANCE = null;
  public static DbManager Instance() throws Exception {
    if (INSTANCE == null) {
      synchronized (DbManager.class) {
        if (INSTANCE == null) {
          INSTANCE = new DbManager();
        }
      }
    }
    return INSTANCE;
  }

  private Connection connection = null;

  private DbManager() throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    connection = DriverManager.getConnection("jdbc:oracle:thin:@mercure.clg.qc.ca:1521:orcl", "VIGNEAUL", "oracle1");
    connection.setAutoCommit(true);
  }

  private PreparedStatement allItems = null;
  public List<Item> findAllItems() throws Exception {
    if (allItems == null) allItems = connection.prepareStatement(
      "SELECT * FROM ITEMS I1 INNER JOIN ITEMLIVRES L ON L.ITEM = I1.ID UNION " +
      "SELECT * FROM ITEMS I2 INNER JOIN ITEMDVDS M ON M.ITEM = I2.ID UNION " +
      "SELECT * FROM ITEMS I3 INNER JOIN ITEMDISQUES A ON A.ITEM = I3.ID"
    );
    ResultSet rs = allItems.executeQuery();
    List<Item> items = new ArrayList<Item>();
    while (rs.next()) {
      int type = rs.getInt(2);
      if (type == 1) {
        items.add(new AlbumItem(rs));
      } else if (type == 2) {
        items.add(new MovieItem(rs));
      } else if (type == 3) {
        items.add(new BookItem(rs));
      } else {
        items.add(new Item(rs));
      }
    }
    return items;
  }

  private PreparedStatement itemById = null;
  public Item findItemById(int id) throws Exception {
    if (itemById == null) itemById = connection.prepareStatement(
      "SELECT * FROM ITEMS I1 INNER JOIN ITEMLIVRES L ON L.ITEM = I1.ID WHERE I1.ID = ? UNION " +
      "SELECT * FROM ITEMS I2 INNER JOIN ITEMDVDS M ON M.ITEM = I2.ID WHERE I2.ID = ? UNION " +
      "SELECT * FROM ITEMS I3 INNER JOIN ITEMDISQUES A ON A.ITEM = I3.ID WHERE I3.ID = ?"
    );
    itemById.setInt(1, id);
    itemById.setInt(2, id);
    itemById.setInt(3, id);
    ResultSet rs = itemById.executeQuery();
    if (rs.next()) {
      int type = rs.getInt(2);
      if (type == 1) {
        return new AlbumItem(rs);
      } else if (type == 2) {
        return new MovieItem(rs);
      } else if (type == 3) {
        return new BookItem(rs);
      } else {
        return new Item(rs);
      }
    } else {
      return null;
    }
  }

  private PreparedStatement itemsByGenre = null;
  public List<Item> findItemsByGenre(int genre) throws Exception {
    if (itemsByGenre == null) itemsByGenre = connection.prepareStatement(
      "SELECT * FROM ITEMS I1 INNER JOIN ITEMLIVRES L ON L.ITEM = I1.ID WHERE I1.GENRE = ? UNION " +
      "SELECT * FROM ITEMS I2 INNER JOIN ITEMDVDS M ON M.ITEM = I2.ID WHERE I2.GENRE = ? UNION " +
      "SELECT * FROM ITEMS I3 INNER JOIN ITEMDISQUES A ON A.ITEM = I3.ID WHERE I3.GENRE = ?"
    );
    itemsByGenre.setInt(1, genre);
    itemsByGenre.setInt(2, genre);
    itemsByGenre.setInt(3, genre);
    ResultSet rs = itemsByGenre.executeQuery();
    List<Item> items = new ArrayList<Item>();
    while (rs.next()) {
      int type = rs.getInt(2);
      if (type == 1) {
        items.add(new AlbumItem(rs));
      } else if (type == 2) {
        items.add(new MovieItem(rs));
      } else if (type == 3) {
        items.add(new BookItem(rs));
      } else {
        items.add(new Item(rs));
      }
    }
    return items;
  }

  private PreparedStatement itemsBySearch = null;
  public List<Item> findItemsBySearch(String query) throws Exception {
    if (itemsBySearch == null) itemsBySearch = connection.prepareStatement(
      "SELECT * FROM ITEMS I1 INNER JOIN ITEMLIVRES L ON L.ITEM = I1.ID WHERE LOWER(I1.TITRE) LIKE '%' || LOWER(?) || '%' UNION " +
      "SELECT * FROM ITEMS I2 INNER JOIN ITEMDVDS M ON M.ITEM = I2.ID WHERE LOWER(I2.TITRE) LIKE '%' || LOWER(?) || '%' UNION " +
      "SELECT * FROM ITEMS I3 INNER JOIN ITEMDISQUES A ON A.ITEM = I3.ID WHERE LOWER(I3.TITRE) LIKE '%' || LOWER(?) || '%'"
    );
    query = query.replaceAll("\\s+", "%");
    itemsBySearch.setString(1, query);
    itemsBySearch.setString(2, query);
    itemsBySearch.setString(3, query);
    ResultSet rs = itemsBySearch.executeQuery();
    List<Item> items = new ArrayList<Item>();
    while (rs.next()) {
      int type = rs.getInt(2);
      if (type == 1) {
        items.add(new AlbumItem(rs));
      } else if (type == 2) {
        items.add(new MovieItem(rs));
      } else if (type == 3) {
        items.add(new BookItem(rs));
      } else {
        items.add(new Item(rs));
      }
    }
    return items;
  }


  private PreparedStatement allGenres = null;
  public List<Genre> findAllGenres() throws Exception {
    if (allGenres == null) allGenres = connection.prepareStatement("SELECT * FROM GENRES");
    ResultSet rs = allGenres.executeQuery();
    List<Genre> genres = new ArrayList<Genre>();
    while (rs.next()) {
      genres.add(new Genre(rs));
    }
    return genres;
  }

  private PreparedStatement genreById = null;
  public Genre findGenreById(int id) throws Exception {
    if (genreById == null) genreById = connection.prepareStatement("SELECT * FROM GENRES G WHERE G.ID = ?");
    genreById.setInt(1, id);
    ResultSet rs = genreById.executeQuery();
    if (rs.next()) {
      return new Genre(rs);
    } else {
      return null;
    }
  }

  private PreparedStatement bookGenres = null;
  public List<Genre> findBookGenres() throws Exception {
    if (bookGenres == null) bookGenres = connection.prepareStatement("SELECT * FROM GENRES G WHERE G.ITEMTYPE = 3");
    ResultSet rs = bookGenres.executeQuery();
    List<Genre> genres = new ArrayList<Genre>();
    while (rs.next()) {
      genres.add(new Genre(rs));
    }
    return genres;
  }

  private PreparedStatement movieGenres = null;
  public List<Genre> findMovieGenres() throws Exception {
    if (movieGenres == null) movieGenres = connection.prepareStatement("SELECT * FROM GENRES G WHERE G.ITEMTYPE = 2");
    ResultSet rs = movieGenres.executeQuery();
    List<Genre> genres = new ArrayList<Genre>();
    while (rs.next()) {
      genres.add(new Genre(rs));
    }
    return genres;
  }

  private PreparedStatement albumGenres = null;
  public List<Genre> findAlbumGenres() throws Exception {
    if (albumGenres == null) albumGenres = connection.prepareStatement("SELECT * FROM GENRES G WHERE G.ITEMTYPE = 1");
    ResultSet rs = albumGenres.executeQuery();
    List<Genre> genres = new ArrayList<Genre>();
    while (rs.next()) {
      genres.add(new Genre(rs));
    }
    return genres;
  }


  private PreparedStatement allBooks = null;
  public List<BookItem> findAllBooks() throws Exception {
    if (allBooks == null) allBooks = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMLIVRES L ON L.ITEM = I.ID");
    ResultSet rs = allBooks.executeQuery();
    List<BookItem> items = new ArrayList<BookItem>();
    while (rs.next()) {
      items.add(new BookItem(rs));
    }
    return items;
  }

  private PreparedStatement booksByGenre = null;
  public List<BookItem> findBooksByGenre(int genre) throws Exception {
    if (booksByGenre == null) booksByGenre = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMLIVRES L ON L.ITEM = I.ID WHERE I.GENRE = ?");
    booksByGenre.setInt(1, genre);
    ResultSet rs = booksByGenre.executeQuery();
    List<BookItem> items = new ArrayList<BookItem>();
    while (rs.next()) {
      items.add(new BookItem(rs));
    }
    return items;
  }


  private PreparedStatement allMovies = null;
  public List<MovieItem> findAllMovies() throws Exception {
    if (allMovies == null) allMovies = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMDVDS M ON M.ITEM = I.ID");
    ResultSet rs = allMovies.executeQuery();
    List<MovieItem> items = new ArrayList<MovieItem>();
    while (rs.next()) {
      items.add(new MovieItem(rs));
    }
    return items;
  }

  private PreparedStatement moviesByGenre = null;
  public List<MovieItem> findMoviesByGenre(int genre) throws Exception {
    if (moviesByGenre == null) moviesByGenre = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMDVDS M ON M.ITEM = I.ID WHERE I.GENRE = ?");
    moviesByGenre.setInt(1, genre);
    ResultSet rs = moviesByGenre.executeQuery();
    List<MovieItem> items = new ArrayList<MovieItem>();
    while (rs.next()) {
      items.add(new MovieItem(rs));
    }
    return items;
  }


  private PreparedStatement allAlbums = null;
  public List<AlbumItem> findAllAlbums() throws Exception {
    if (allAlbums == null) allAlbums = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMDISQUES A ON A.ITEM = I.ID");
    ResultSet rs = allAlbums.executeQuery();
    List<AlbumItem> items = new ArrayList<AlbumItem>();
    while (rs.next()) {
      items.add(new AlbumItem(rs));
    }
    return items;
  }

  private PreparedStatement albumsByGenre = null;
  public List<AlbumItem> findAlbumsByGenre(int genre) throws Exception {
    if (albumsByGenre == null) albumsByGenre = connection.prepareStatement("SELECT * FROM ITEMS I INNER JOIN ITEMDISQUES A ON A.ITEM = I.ID WHERE I.GENRE = ?");
    albumsByGenre.setInt(1, genre);
    ResultSet rs = albumsByGenre.executeQuery();
    List<AlbumItem> items = new ArrayList<AlbumItem>();
    while (rs.next()) {
      items.add(new AlbumItem(rs));
    }
    return items;
  }


  private PreparedStatement clientById = null;
  public Client findClientById(int id) throws Exception {
    if (clientById == null) clientById = connection.prepareStatement("SELECT * FROM CLIENTS C WHERE C.ID = ?");
    clientById.setInt(1, id);
    ResultSet rs = clientById.executeQuery();
    if (rs.next()) {
      return new Client(rs);
    } else {
      return null;
    }
  }

  private PreparedStatement clientLogIn = null;
  public Client findClientByLogin(String email, String password) throws Exception {
    if (clientLogIn == null) clientLogIn = connection.prepareStatement("SELECT * FROM CLIENTS C WHERE C.EMAIL = ? AND C.PASSWORD = ?");
    clientLogIn.setString(1, email);
    clientLogIn.setString(2, Client.hashPassword(password));
    ResultSet rs = clientLogIn.executeQuery();
    if (rs.next()) {
      return new Client(rs);
    } else {
      return null;
    }
  }

  private PreparedStatement insertClient = null;
  public Boolean save(Client client) throws Exception {
    if (insertClient == null) insertClient = connection.prepareStatement("INSERT INTO CLIENTS (nom, prenom, addresse, ville, ccnumber, ccmonth, ccyear, cctype, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    insertClient.setString(1, client.getNom());
    insertClient.setString(2, client.getPrenom());
    insertClient.setString(3, client.getAddresse());
    insertClient.setString(4, client.getVille());
    insertClient.setString(5, client.getCcNumber());
    insertClient.setInt(6, client.getCcMonth());
    insertClient.setInt(7, client.getCcYear());
    insertClient.setString(8, client.getCcType());
    insertClient.setString(9, client.getEmail());
    insertClient.setString(10, client.getPassword());
    return (insertClient.executeUpdate() > 0);
  }


  private PreparedStatement orderId = null;
  public int nextOrderId() throws Exception {
    if (orderId == null) orderId = connection.prepareStatement("SELECT SEQ_COMMANDES.NEXTVAL FROM DUAL");
    ResultSet rs = orderId.executeQuery();
    if (rs.next()) {
      return rs.getInt(1);
    } else {
      return 0;
    }
  }

  private PreparedStatement insertOrder = null;
  public Boolean save(Commande commande) throws Exception {
    if (insertOrder == null) insertOrder = connection.prepareStatement("INSERT INTO COMMANDES (id, client, tstamp, pst, gst, total) VALUES (?, ?, SYSDATE, ?, ?, ?)");
    insertOrder.setInt(1, commande.getId());
    insertOrder.setInt(2, commande.getClient());
    insertOrder.setDouble(3, commande.getPst());
    insertOrder.setDouble(4, commande.getGst());
    insertOrder.setDouble(5, commande.getTotal());
    return (insertOrder.executeUpdate() > 0);
  }

  private PreparedStatement insertOrderEntry = null;
  public Boolean saveToOrder(Commande commande, CartEntry entry) throws Exception {
    if (insertOrderEntry == null) insertOrderEntry = connection.prepareStatement("INSERT INTO ITEMSCOMMANDES (commande, item, prix, qte) VALUES (?, ?, ?, ?)");
    insertOrderEntry.setInt(1, commande.getId());
    insertOrderEntry.setInt(2, entry.getItem().getId());
    insertOrderEntry.setDouble(3, entry.getItem().getPrix());
    insertOrderEntry.setInt(4, entry.getQte());
    return (insertOrderEntry.executeUpdate() > 0);
  }
}
