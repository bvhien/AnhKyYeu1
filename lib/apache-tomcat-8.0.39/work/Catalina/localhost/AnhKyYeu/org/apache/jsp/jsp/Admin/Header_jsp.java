/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.39
 * Generated at: 2017-04-15 11:03:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Quản trị hệ thống</title>\n");
      out.write("        <!--Css-->\n");
      out.write("        <link href=\"../../css/Libcss/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../fonts/font-awesome-4.7.0/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/Libcss/sb-admin.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/Libcss/dataTables.bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/Libcss/jquery-ui.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/Libcss/editor.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/Style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!-- jQuery Version 1.11.0 -->\n");
      out.write("        <script src=\"../../js/Libjs/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/angular.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/angular-route.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/jquery-ui.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/jquery.ui.datepicker-vi.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/UTF-8.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/Libjs/editor.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--<script src=\"../js/Libjs/jquery.dataTables.js\" type=\"text/javascript\"></script>-->\n");
      out.write("        <!--<script src=\"../js/Libjs/dataTables.bootstrap.js\" type=\"text/javascript\"></script>-->\n");
      out.write("        <script src=\"../../js/Libjs/dirPagination.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("//            var app = angular.module('app',['angularUtils.directives.dirPagination']);\n");
      out.write("//            var app = angular.module('app', ['ngRoute']).directive('capitalize', function () {\n");
      out.write("            var app = angular.module('app', ['angularUtils.directives.dirPagination']).directive('capitalize', function () {\n");
      out.write("                return {\n");
      out.write("                    require: 'ngModel',\n");
      out.write("                    link: function (scope, element, attrs, modelCtrl) {\n");
      out.write("                        var capitalize = function (inputValue) {\n");
      out.write("                            if (inputValue == undefined)\n");
      out.write("                                inputValue = '';\n");
      out.write("                            var capitalized = inputValue.toUpperCase();\n");
      out.write("                            if (capitalized !== inputValue) {\n");
      out.write("                                modelCtrl.$setViewValue(capitalized);\n");
      out.write("                                modelCtrl.$render();\n");
      out.write("                            }\n");
      out.write("                            return capitalized;\n");
      out.write("                        }\n");
      out.write("                        modelCtrl.$parsers.push(capitalize);\n");
      out.write("                        capitalize(scope[attrs.ngModel]); // capitalize initial value\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("            });\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var url = window.location.href;\n");
      out.write("                $('.navbar-nav li').each(function () {\n");
      out.write("                    console.log(this.firstElementChild.href);\n");
      out.write("                    if (url === (this.firstElementChild.href)) {\n");
      out.write("                        $(this).addClass('active');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                //                $('#example').DataTable();\n");
      out.write("                $(\"#txtEditor\").Editor();\n");
      out.write("                List();\n");
      out.write("                $(function () {\n");
      out.write("                    $(\".datepicker\").datepicker({changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', yearRange: '-70y:+70y'});\n");
      out.write("                    ;\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script src=\"../../js/Validate.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../../js/CheckLogin.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body ng-app=\"app\">\n");
      out.write("\n");
      out.write("        <form id=\"wrapper\"  name=\"myForm\" ng-controller=\"Ctrl\" >\n");
      out.write("            ");
 request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("            <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("                <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.html\">Quản trị hệ thống</a>\n");
      out.write("                </div>\n");
      out.write("                <!-- Top Menu Items -->\n");
      out.write("                <ul class=\"nav navbar-right top-nav\">\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i>&nbsp;<b id=\"ThongTinTK\"></b><b class=\"caret\">&nbsp;</b></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\" onclick=\"DangXuat()\n");
      out.write("                                            ;\"><i class=\"fa fa-fw fa-power-off\"></i> Đăng xuất</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->\n");
      out.write("                <div class=\"collapse navbar-collapse navbar-ex1-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav side-nav\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Thamso.jsp\"><i class=\"fa fa-fw fa-link\"></i> Tham số</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Album.jsp\"><i class=\"fa fa-fw fa-folder-open-o\"></i> Album</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Image.jsp\"><i class=\"fa fa-fw fa-picture-o\"></i> Image</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"User.jsp\"><i class=\"fa fa-fw fa-user-circle\"></i> Người dùng</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"Article.jsp\"><i class=\"fa fa-fw fa-newspaper-o\"></i> Bài viết</a>\n");
      out.write("                        </li>\n");
      out.write("<!--                        <li>\n");
      out.write("                            <a href=\"AddArticle.jsp\"><i class=\"fa fa-fw fa-wrench\"></i> Bootstrap Grid</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"javascript:;\" data-toggle=\"collapse\" data-target=\"#demo\"><i class=\"fa fa-fw fa-arrows-v\"></i> Dropdown <i class=\"fa fa-fw fa-caret-down\"></i></a>\n");
      out.write("                            <ul id=\"demo\" class=\"collapse\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Dropdown Item</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Dropdown Item</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"blank-page.html\"><i class=\"fa fa-fw fa-file\"></i> Blank Page</a>\n");
      out.write("                        </li>-->\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.navbar-collapse -->\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <div id=\"page-wrapper\">\n");
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
