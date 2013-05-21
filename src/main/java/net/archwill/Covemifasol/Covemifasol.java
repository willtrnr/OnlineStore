package net.archwill.Covemifasol;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Covemifasol extends HttpServlet {
  private JadeConfiguration jade = new JadeConfiguration();

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    response.setStatus(HttpServletResponse.SC_OK);
    //response.getWriter().println("<h1>Hello Servlet</h1>");
    //response.getWriter().println("session=" + request.getSession(true).getId());
    JadeTemplate index = jade.getTemplate("index.jade");
    response.getOutputStream().print(jade.renderTemplate(index, new HashMap<String, Object>()));
  }
}
