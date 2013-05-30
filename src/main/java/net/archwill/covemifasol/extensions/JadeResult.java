package net.archwill.covemifasol.extensions;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class JadeResult implements Result {
  private static final Logger logger = Logger.getLogger(JadeResult.class);
  private static final JadeConfiguration jade = new JadeConfiguration();

  public static final String DEFAULT_PARAM = "location";

  private String location;

  public void execute(ActionInvocation ai) throws Exception {
    ServletActionContext.getResponse().setContentType("text/html");
    File file = new File(ServletActionContext.getServletContext().getRealPath("/"), location);
    JadeTemplate template = jade.getTemplate(file.getAbsolutePath());
    ServletActionContext.getResponse().getOutputStream().print(jade.renderTemplate(template, ai.getStack().getContext()));
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
