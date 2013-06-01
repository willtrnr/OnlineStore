package net.archwill.covemifasol.extensions;

public class UrlHelper {
  public UrlHelper() {

  }

  public String action(String action, Object... params) {
    return "/" + action + ".action";
  }
}
