package net.archwill.covemifasol.extensions;

import java.io.File;

public class UrlHelper {
  private String webRoot;

  public UrlHelper(String webRoot) {
    this.webRoot = webRoot;
  }

  // TODO: Check the base URL for real
  public String action(String action) {
    return "/" + action + ".action";
  }

  // TODO: Check the base URL for real
  public String resource(String path) {
    return "/" + path;
  }

  public String item(int id, int width, int height) {
    File imgRoot = new File(webRoot, "img/items");
    if (new File(imgRoot, id + ".jpg").isFile()) {
      return "/img/items/" + Integer.toString(id) + ".jpg";
    } else if (new File(imgRoot, id + ".png").isFile()) {
      return "/img/items/" + Integer.toString(id) + ".png";
    } else if (new File(imgRoot, id + ".gif").isFile()) {
      return "/img/items/" + Integer.toString(id) + ".gif";
    } else {
      return "holder.js/" + Integer.toString(width) + "x" + Integer.toString(height);
    }
  }
}
