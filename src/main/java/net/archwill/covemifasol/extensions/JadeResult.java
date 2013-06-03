package net.archwill.covemifasol.extensions;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.archwill.covemifasol.actions.Action;
import org.apache.struts2.ServletActionContext;

public class JadeResult implements Result {
  private static final Logger LOGGER;

  private static final JadeConfiguration JADE;
  public static final String DEFAULT_PARAM;

  static {
    LOGGER = LoggerFactory.getLogger(JadeResult.class);
    JADE = new JadeConfiguration();
    Map<String, Object> defaults = new HashMap<String, Object>();
    defaults.put("title", "Covemifasol");
    defaults.put("pagetitle", "Covemifasol");
    defaults.put("url", new UrlHelper());
    JADE.setSharedVariables(defaults);
    JADE.setCaching(false);
    DEFAULT_PARAM = "location";
  }

  private String location;

  public void execute(ActionInvocation ai) throws Exception {
    ServletActionContext.getResponse().setContentType("text/html");
    File file = new File(ServletActionContext.getServletContext().getRealPath("/views/"), location);
    JadeTemplate template = JADE.getTemplate(file.getAbsolutePath());
    JADE.renderTemplate(template, ((Action)ai.getAction()).getLocals(), ServletActionContext.getResponse().getWriter());
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
