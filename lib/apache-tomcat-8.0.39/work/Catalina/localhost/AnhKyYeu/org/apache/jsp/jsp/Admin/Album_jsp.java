/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.39
 * Generated at: 2017-04-15 11:26:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Album_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <h4 class=\"title\">Quản lý Album</h4>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\" col-md-6\" ng-class=\"myForm.TieuDe.$invalid?'invalid form-group ':'form - group'\">\n");
      out.write("                    <label>Tiêu đề Album:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" ng-model=\"Album.TieuDe\" name=\"TieuDe\" id=\"TieuDe\" val-required>\n");
      out.write("                    <span ng-show=\"myForm.TieuDe.$error.valRequired\" class=\"validate-text\">Tiêu đề là bắt buộc nhập</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\" col-md-3\" ng-class=\"myForm.DanhMuc.$invalid?'invalid form-group ':'form - group'\">\n");
      out.write("                    <label>Chọn danh mục:</label>\n");
      out.write("                    <select class=\"form-control\" ng-model=\"Album.DanhMuc\" name=\"DanhMuc\" ng-options=\"p.categoryId as p.categoryName for p in DanhMuc\" val-required>\n");
      out.write("                        <option value=\"\">---Chọn danh mục Album---</option>\n");
      out.write("                    </select>\n");
      out.write("                    <span ng-show=\"myForm.DanhMuc.$error.valRequired\" class=\"validate-text\">Danh mục Album là bắt buộc nhập</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\" col-md-3\" ng-class=\"myForm.TrangThai.$invalid?'invalid form-group ':'form - group'\">\n");
      out.write("                    <label>Trạng thái kích hoạt:</label>\n");
      out.write("                    <select class=\"form-control\" ng-model=\"Album.TrangThai\" name=\"TrangThai\" ng-options=\"tt.MaThamSo as tt.DienGiai for tt in TrangThai\" val-required>\n");
      out.write("                        <option value=\"\">---Chọn trạng thái kích hoạt---</option>\n");
      out.write("                    </select>\n");
      out.write("                    <span ng-show=\"myForm.TrangThai.$error.valRequired\" class=\"validate-text\">Trạng thái là bắt buộc nhập</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <label>Ghi chú</label>\n");
      out.write("                    <textarea class=\"form-control\" rows=\"5\" ng-model=\"Album.GhiChu\"></textarea>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <label>Ảnh tiêu đề:</label>\n");
      out.write("                        <input type=\"file\" ng-model-instant onchange=\"angular.element(this).scope().imageChoose(event)\" class=\"file\">\n");
      out.write("                            <span ng-show=\"myForm.Image.$error.valRequired\" class=\"validate-text\">Ảnh tiêu đề là bắt buộc</span>\n");
      out.write("                        <a ng-show=\"!isEdit\" href=\"#\" class=\"btn btn-primary footer\" role=\"button\" ng-click=\"ThemAlbum()\"><i class=\"fa fa-floppy-o\"></i> Thêm Album  mới</a>\n");
      out.write("                        <a ng-show=\"isEdit\" href=\"#\" class=\"btn btn-primary footer\" role=\"button\" ng-click=\"CapNhat()\"><i class=\"fa fa-floppy-o\"></i> Lưu</a>\n");
      out.write("                        <a ng-show=\"isEdit\" href=\"#\" class=\"btn btn-default footer\" role=\"button\" ng-click=\"Huy()\"><i class=\"fa fa-ban\"></i> Hủy</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div ng-repeat=\"step in stepsModel\">\n");
      out.write("                            <img class=\"thumb\" ng-src=\"{{step}}\" name=\"Image\"/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("        <div class=\"row\"><hr>\n");
      out.write("            <form class=\"form-inline\">\n");
      out.write("                <div class=\"form-group col-md-3\">\n");
      out.write("                    <label >Tìm kiếm</label>\n");
      out.write("                    <input type=\"text\" ng-model=\"search\" class=\"form-control\" placeholder=\"Tìm kiếm\">\n");
      out.write("                </div>\n");
      out.write("                <div style=\"text-align: right;\">\n");
      out.write("                    <dir-pagination-controls\n");
      out.write("                        max-size=\"5\"\n");
      out.write("                        direction-links=\"true\"\n");
      out.write("                        boundary-links=\"true\" >\n");
      out.write("                    </dir-pagination-controls>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <table id=\"example\" class=\"table table-bordered table-hover table-striped table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th ng-click=\"sort('Id')\" class=\"cursor\">ID</th>\n");
      out.write("                    <th ng-click=\"sort('AnhTieuDe')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Ảnh hiển thị</th>\n");
      out.write("                    <th ng-click=\"sort('TieuDe')\" class=\"cursor \"><i class=\"fa fa-sort\"></i> Tên Album</th>\n");
      out.write("                    <th ng-click=\"sort('DanhMuc1')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Khoa</th>\n");
      out.write("                    <th ng-click=\"sort('TrangThai1')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Trạng thái</th>\n");
      out.write("                    <th ng-click=\"sort('GhiChu')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Ghi chú</th>\n");
      out.write("                    <th ng-click=\"sort('NgayTao')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Ngày tạo</th>\n");
      out.write("                    <th ng-click=\"sort('NgaySua')\" class=\"cursor\"><i class=\"fa fa-sort\"></i> Ngày sửa</th>\n");
      out.write("                    <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr dir-paginate=\"al in TblAlbum|orderBy:sortKey:reverse|filter:search|itemsPerPage:5\" ng-class=\"{select : $index == selectIndex}\">\n");
      out.write("                    <td>\n");
      out.write("                        <input ng-model=\"al.Checked\"  ng-true-value=\"1\" ng-false-value=\"0\" type=\"checkbox\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>{{al.Id}}</td>\n");
      out.write("                    <td><img src=\"../../Guest-Image/{{al.AnhTieuDe}}\" class=\"ShowImage\"/></td>\n");
      out.write("                    <td>{{al.TieuDe}}</td>\n");
      out.write("                    <td>{{al.DanhMuc1}}</td>\n");
      out.write("                    <td>{{al.TrangThai1}}</td>\n");
      out.write("                    <td>{{al.GhiChu}}</td>\n");
      out.write("                    <td>{{al.NgayTao}}</td>\n");
      out.write("                    <td>{{al.NgaySua}}</td>\n");
      out.write("                    <td style=\"padding: 5px 0px;\"><a class=\"btn btn-danger\" ng-click=\"XoaBanGhi(al.Id)\"><i class=\"fa fa-trash\"></i> Xóa</a>\n");
      out.write("                        <a class=\"btn btn-default\" ng-click=\"SuaBanGhi(al.Id)\"><i class=\"fa fa-pencil\"></i> Sửa</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <a ng-click=\"XoaNhieuBanGhi()\" class=\"btn btn-danger\" role=\"button\">Xóa bản ghi đã chọn</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Album-dialog-save\" title=\"Thông báo\">\n");
      out.write("            <p>\n");
      out.write("            <span class=\"ui-icon ui-icon-alert\"\n");
      out.write("                  style=\"float: left; margin: 0 7px 20px 0;\"></span>Lưu thành công\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"Album-dialog-thongbao\" title=\"Thông báo\">\n");
      out.write("        </div>\n");
      out.write("    </div>    \n");
      out.write("    <script src=\"../../js/Album.js\" type=\"text/javascript\"></script>\n");
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
