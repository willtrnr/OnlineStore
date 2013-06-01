package net.archwill.covemifasol.extensions;

public class UrlHelper {
  // TODO: Check the base URL for real
  public String action(String action, Object... params) {
    return "/" + action + ".action";
  }

  // TODO: Check the base URL for real
  public String resource(String path) {
    return "/" + path;
  }
}
