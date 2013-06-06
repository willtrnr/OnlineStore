package net.archwill.covemifasol.extensions;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.archwill.covemifasol.actions.Action;
import org.apache.struts2.ServletActionContext;

public class JadeResult implements Result {
  private static final Logger LOGGER = LoggerFactory.getLogger(JadeResult.class);

  private static final JadeConfiguration JADE;
  public static final String DEFAULT_PARAM;

  static {
    JADE = new JadeConfiguration();
    Map<String, Object> defaults = new HashMap<String, Object>();
    defaults.put("title", "Covemifasol");
    defaults.put("format", new FormatHelper());
    JADE.setSharedVariables(defaults);
    JADE.setCaching(false);
    DEFAULT_PARAM = "location";
  }

  public void execute(ActionInvocation ai) throws Exception {
    ServletActionContext.getResponse().setContentType("text/html");
    File file = new File(ServletActionContext.getServletContext().getRealPath("/views/"), location);
    LOGGER.debug("Jade rendering '#0'", file.toString());
    JadeTemplate template = JADE.getTemplate(file.getAbsolutePath());
    Map<String, Object> locals = null;
    try {
      locals = ((Action)ai.getAction()).getLocals();
    } catch (Exception ex) {
      locals = new HashMap<String, Object>();
    }
    locals.put("url", new UrlHelper(ServletActionContext.getServletContext().getRealPath("/")));
    JADE.renderTemplate(template, locals, ServletActionContext.getResponse().getWriter());
  }

  private String location;
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
}
