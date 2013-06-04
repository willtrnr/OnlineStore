package net.archwill.covemifasol.extensions;

import java.util.Locale;

public class FormatHelper {
  public String price(double price) {
    return String.format(Locale.US, "%1$,.2f", price);
  }

  public String maxLen(String str, int len) {
    if (str.length() <= len) {
      return str;
    } else {
      return str.substring(0, len) + "...";
    }
  }
}
