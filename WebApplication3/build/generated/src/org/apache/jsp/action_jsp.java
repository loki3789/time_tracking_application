package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.database.Database_controller;

public final class action_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styleforapp.css\">\n");
      out.write("        <script src=\"javs.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"controller_to_save_time\" id=\"myForm\" > \n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" name=\"working_on\" placeholder=\"type what are you doing\"/>\n");
      out.write("                <select  name=\"category\" onchange=\"getval(this);\">\n");
      out.write("                    <option value=\"select\">select category</option>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <option value=\"Personal\" >Personal</option>\n");
      out.write("                    <option value=\"Work\">Work</option>\n");
      out.write("                    <option value=\"Meeting\">Meeting</option>\n");
      out.write("                    <option value=\"Refreshment\">Refreshment</option>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" id=\"time\" name=\"time_elapsed\" value=\"00\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        </br>\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"ta1\" style=\"visibility: hidden\">\n");
      out.write("            <div>  \n");
      out.write("                <table style=\"margin-left:-250px\">\n");
      out.write("                    <th>  \n");
      out.write("                        <button id= \"startPause\" onclick=\"startPause()\"><b id=\"start\">Start</b></button></th>\n");
      out.write("                    <th><h1><p id=\"output\">0:00:00:00</p></h1></th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <th><button onclick=\"get_total_time()\" id=\"reset\"><b id=\"reset\">Stop</b</button></th>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("<table style=\"margin-top: 100px;\">\n");
      out.write("    <tr>\n");
      out.write("      <th>Working on</th>\n");
      out.write("      <th>Duration</th>\n");
      out.write("      <th>Category</th>\n");
      out.write("      <th>Date</th>\n");
      out.write("    </tr>\n");
      out.write("    ");
 
 Database_controller db=new Database_controller();
 ResultSet rs = db.get();
 while (rs.next()) {
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("      <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("      <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("      <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("      <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("    </tr>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("  </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
