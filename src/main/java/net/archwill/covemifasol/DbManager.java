package net.archwill.covemifasol;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import java.sql.DriverManager;
import java.sql.Connection;

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
  }
}
