package net.archwill.covemifasol.actions;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
  private String test;

  @Override
  public String execute() throws Exception {

    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }
}
