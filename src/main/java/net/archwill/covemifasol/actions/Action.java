package net.archwill.covemifasol.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class Action extends ActionSupport implements SessionAware, ParameterNameAware {
  protected Map<String, Object> locals;
  protected Map<String, Object> session;

  public Action() {
    locals = new HashMap<String, Object>();
  }

  public Map<String, Object> getLocals() {
    return locals;
  }

  @Override
  public void setSession(Map<String, Object> session) {
    this.session = session;
    locals.put("session", session);
  }

  @Override
  public boolean acceptableParameterName(String parameterName) {
    return !(parameterName.startsWith("session") || parameterName.startsWith("request"));
  }
}
