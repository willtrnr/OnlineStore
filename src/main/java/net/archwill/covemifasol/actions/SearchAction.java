package net.archwill.covemifasol.actions;

import net.archwill.covemifasol.DbManager;

public class SearchAction extends Action {
  @Override
  public String execute() throws Exception {
    super.execute();
    if (query != null) {
      locals.put("items", DbManager.Instance().findItemsBySearch(query));
    }
    return SUCCESS;
  }

  private String query;
  public String getQuery() {
    return query;
  }
  public void setQuery(String query) {
    this.query = query;
    locals.put("query", query);
  }
}
