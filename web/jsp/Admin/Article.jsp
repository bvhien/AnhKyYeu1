<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
        <div class="row">
            <h4 class="title">Quản lý bài viết</h4>
            <div class="container-fluid" id="AddArticle" title="Thêm mới bài viết" ng-show="isShowDetail">
                <h5 style="font-weight: bold;">Thêm mới bài viết</h5>
                <div class="row">
                    <div class="col-md-4" ng-class="myForm.Section.$invalid?'invalid form-group ':'form - group'">
                        <label>Thể loại:</label>
                        <select  class="form-control" ng-model="Article.Section" name="Section" ng-options="pm.MaThamSo as pm.DienGiai for pm in Permiss" val-required>
                            <option value="">---Chọn thể loại bài viết---</option>
                        </select>
                        <span ng-show="myForm.Section.$error.valRequired" class="validate-text">Thể loại là bắt buộc chọn</span>
                    </div>
                    <div class="col-md-4" ng-class="myForm.Status.$invalid?'invalid form-group ':'form - group'">
                        <label>Trạng thái kích hoạt:</label>
                        <select  class="form-control" ng-model="Article.Status" name="Status" ng-options="pm.MaThamSo as pm.DienGiai for pm in Permiss" val-required>
                            <option value="">---Chọn trạng thái kích hoạt---</option>
                        </select>
                        <span ng-show="myForm.Status.$error.valRequired" class="validate-text">Thể loại là bắt buộc chọn</span>
                    </div>
                    <div class=" col-md-4" ng-class="myForm.Title.$invalid?'invalid form-group ':'form - group'">
                        <label>Tiêu đề bài viết:</label>
                        <input placeholder="Nhập tiêu đề" type="text" class="form-control" ng-model="Article.Title" name="Title" id="Title" val-required>
                        <span ng-show="myForm.Title.$error.valRequired" class="validate-text">Tên đăng nhập là bắt buộc nhập</span>
                    </div>
                    <div class="col-md-4">
                        <div class="col-md-7">
                            <label>Ảnh tiêu đề:</label>
                            <input type="file" ng-model-instant onchange="angular.element(this).scope().imageChoose(event)" name="Image" class="file">
                        </div>
                        <div class="col-md-5">
                            <div ng-repeat="step in stepsModel">
                                <img class="thumb" ng-src="{{step}}" name="Image"/>
                            </div>
                        </div>
                    </div>
                    <div class=" col-md-4" ng-class="myForm.Summary.$invalid?'invalid form-group ':'form - group'">
                        <label>Nội dung tóm tắt:</label>
                        <input type="text" class="form-control" name="Summary"ng-model="Article.Summary" val-required>
                        <span ng-show="myForm.Summary.$error.valRequired" class="validate-text">Nội dung tóm tắt là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-4" ng-class="myForm.OrderNo.$invalid?'invalid form-group ':'form - group'">
                        <label>Sắp xếp:</label>
                        <input type="number" class="form-control" name="OrderNo"ng-model="Article.OrderNo" val-required>
                        <span ng-show="myForm.OrderNo.$error.valRequired" class="validate-text">Sắp xếp là bắt buộc nhập</span>
                    </div>
                    
                </div>
                <div class="row">
                    <label>Nội dung:</label>
                    <div class="col-md-12 nopadding" ng-class="myForm.Content.$invalid?'invalid form-group ':'form - group'">
                        <textarea id="txtEditor" ng-model="Article.Content" name="Content" val-required></textarea> 
                        <span ng-show="myForm.Content.$error.valRequired" class="validate-text">Nội dung là bắt buộc nhập</span>
                    </div>
                    <div class="col-md-4">
                        <a  href="#" class="btn btn-primary footer" role="button" ng-click="ThemArticle()"><i class="fa fa-floppy-o"></i> Lưu</a>
                        <a  href="#" class="btn btn-danger footer" role="button" ng-click="Huy()"><i class="fa fa-floppy-o"></i> Hủy</a>
                    </div>
                </div>
            </div>
    <div class="row">
        <h5 style="font-weight: bold;">Danh mục bài viết</h5>
        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-condensed" id="example">
            <thead>
                <tr>
                <th>Rendering engine</th>
                <th>Noi Dung</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
                </tr>
            </thead>
            <tbody>
                <tr class="odd gradeX">
                <td>Trident</td>
                <td>Internet
                    Explorer 4.0</td>
                <td>Win 95+</td>
                <td class="center"> 4</td>
                <td class="center">X</td>
                </tr>

            </tbody>
        </table>
        <a href="#" class="btn btn-success" ng-click="AddArticle()">Thêm bản ghi mới</a>
        <a href="#" class="btn btn-danger" role="button">Xóa bản ghi đã chọn</a>          
    </div>
</div>



<script src="../../js/Article.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>