package net.archwill.covemifasol;

import org.apache.log4j.Logger;

public class DbManager {
  private static final Logger logger = Logger.getLogger(DbManager.class);
  private static DbManager INSTANCE = null;

  public static DbManager Instance() {
    if (INSTANCE == null) {
      synchronized (DbManager.class) {
        if (INSTANCE == null) {
          INSTANCE = new DbManager();
        }
      }
    }
    return INSTANCE;
  }

  private DbManager() {}
}
