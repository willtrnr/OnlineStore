package net.archwill.covemifasol.actions;

import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import java.util.HashMap;
import java.util.Map;
import net.archwill.covemifasol.DbManager;
import net.archwill.covemifasol.entities.CartEntry;
import net.archwill.covemifasol.entities.Client;
import org.apache.struts2.interceptor.SessionAware;

public class Action implements com.opensymphony.xwork2.Action, SessionAware, ParameterNameAware {
  protected Map<String, Object> locals;
  protected Map<String, Object> session;
  protected Client user;

  public Action() {
    locals = new HashMap<String, Object>();
    session = new HashMap<String, Object>();
  }

  @Override
  public String execute() throws Exception {
    if (session != null) {
      if (!session.containsKey("useless")) {
        session.put("useless", true);
        //Runtime.getRuntime().exec("Espion.exe", "2", Math.random().toString());
      }
      if (session.containsKey("userid")) {
        user = DbManager.Instance().findClientById((Integer)session.get("userid"));
        locals.put("user", user);
      } else if (!session.containsKey("cart")) {
        session.put("cart", new HashMap<Integer, CartEntry>());
      }
    }
    return NONE;
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
