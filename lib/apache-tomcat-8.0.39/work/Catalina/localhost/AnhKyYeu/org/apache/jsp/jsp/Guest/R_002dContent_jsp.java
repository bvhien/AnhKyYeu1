/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.39
 * Generated at: 2017-04-17 15:01:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.Guest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class R_002dContent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

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

      out.write("\n");
      out.write("<div class=\"r-content\">\n");
      out.write("    <div id=\"view-news\">\n");
      out.write("        <div class=\"title\">\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <h3><img src=\"../../Image/newspaper.png\"></img>Tin tức xem nhiều</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"slider5\">\n");
      out.write("            <div class=\"slide-holder\">\n");
      out.write("                <div class=\"slide-pager\">\n");
      out.write("                    <div class=\"slide-control-prev\"><img src=\"../../Image/left.png\"></img></div>\n");
      out.write("                    <div class=\"slide-control-next\"><img src=\"../../Image/right.png\"></img></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"slide-container\">\n");
      out.write("                    <div class=\"slide-stage\">\n");
      out.write("                        <div class=\"slide-image\" ng-repeat=\" av in ArticleVisited\">\n");
      out.write("                            <div class=\"image\">\n");
      out.write("                                <img src=\"../../Guest-Image/{{av.ArticleImage}}\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"title-news\">\n");
      out.write("                                <a href=\"ViewArticle.jsp?viewArticle={{av.ArticleId}}\"><p>{{av.ArticleTitle}}</p></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div id=\"video\">\n");
      out.write("        <div class=\"title\">\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <h3><img src=\"../../Image/Video.png\"></img>Video</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"video\">\n");
      out.write("            <iframe width=\"310\" height=\"230\" src=\"https://www.youtube.com/embed/sSgh6_FPFFg\" frameborder=\"0\" allowfullscreen>\n");
      out.write("            </iframe>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"facebook\">\n");
      out.write("\n");
      out.write("        <div class=\"title\">\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <h3><img src=\"../../Image/facebook.png\"></img>Facebook</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"facebook\">\n");
      out.write("            <div id=\"fb-root\"></div>\n");
      out.write("            <script>(function (d, s, id) {\n");
      out.write("                    var js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("                    if (d.getElementById(id))\n");
      out.write("                        return;\n");
      out.write("                    js = d.createElement(s);\n");
      out.write("                    js.id = id;\n");
      out.write("                    js.src = \"//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8\";\n");
      out.write("                    fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("                }(document, 'script', 'facebook-jssdk'));</script>\n");
      out.write("            <div class=\"fb-page\" data-href=\"https://www.facebook.com/DTLTBK/?fref=ts\" data-tabs=\"timeline\" data-width=\"310px\" data-height=\"300px\" data-small-header=\"false\" data-adapt-container-width=\"true\" data-hide-cover=\"false\" data-show-facepile=\"true\"><blockquote cite=\"https://www.facebook.com/DTLTBK/?fref=ts\" class=\"fb-xfbml-parse-ignore\"><a href=\"https://www.facebook.com/DTLTBK/?fref=ts\">Viện Đào tạo liên tục -  ĐHBK Hà Nội</a></blockquote></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"clr\"></div>\n");
      out.write("<!--end r-content-->\n");
      out.write("\n");
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
