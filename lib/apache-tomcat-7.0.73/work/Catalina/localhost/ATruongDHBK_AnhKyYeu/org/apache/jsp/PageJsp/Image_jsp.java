/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2016-12-30 10:22:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.PageJsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Image_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <script src=\"../js/AlbumJs/AddImage.js\" type=\"text/javascript\"></script>\n");
      out.write("    <div ng-controller=\"AddImage\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <h4 class=\"title\">Quản lý Ảnh</h4>\n");
      out.write("            <div class=\" col-md-3\">\n");
      out.write("                <label>Chọn Album:</label>\n");
      out.write("                <select class=\"form-control\">\n");
      out.write("                    <option>1</option>\n");
      out.write("                    <option>2</option>\n");
      out.write("                    <option>3</option>\n");
      out.write("                    <option>4</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\" col-md-3\">\n");
      out.write("                <label>Trạng thái kích hoạt:</label>\n");
      out.write("                <select class=\"form-control\" >\n");
      out.write("                    <option>1</option>\n");
      out.write("                    <option>2</option>\n");
      out.write("                    <option>3</option>\n");
      out.write("                    <option>4</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--    <div class=\"row form-upload-img\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <label for=\"files\">Select multiple files: </label>\n");
      out.write("                    <input id=\"files\" type=\"file\" multiple/>\n");
      out.write("                    <output id=\"result\" />\n");
      out.write("                </div>\n");
      out.write("            </div>-->\n");
      out.write("        <div ng-repeat=\"step in stepsModel\">\n");
      out.write("            <img class=\"thumb\" ng-src=\"{{step}}\" />\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <input type='file' ng-model-instant onchange=\"angular.element(this).scope().imageUpload(event)\" multiple />\n");
      out.write("        <a href=\"\" ng-click=\"Upload()\">Upload</a>\n");
      out.write("    </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
