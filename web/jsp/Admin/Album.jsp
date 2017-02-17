<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <div>
        <div class="row">
            <h4 class="title">Quản lý Album</h4>
            <div class="row">
                <div class=" col-md-6" ng-class="myForm.TieuDe.$invalid?'invalid form-group ':'form - group'">
                    <label>Tiêu đề Album:</label>
                    <input type="text" class="form-control" ng-model="Album.TieuDe" name="TieuDe" id="TieuDe" val-required>
                    <span ng-show="myForm.TieuDe.$error.valRequired" class="validate-text">Tiêu đề là bắt buộc nhập</span>
                </div>
                <div class=" col-md-3" ng-class="myForm.DanhMuc.$invalid?'invalid form-group ':'form - group'">
                    <label>Chọn danh mục:</label>
                    <select class="form-control" ng-model="Album.DanhMuc" name="DanhMuc" ng-options="p.categoryId as p.categoryName for p in DanhMuc" val-required>
                        <option value="">---Chọn danh mục Album---</option>
                    </select>
                    <span ng-show="myForm.DanhMuc.$error.valRequired" class="validate-text">Danh mục Album là bắt buộc nhập</span>
                </div>
                <div class=" col-md-3" ng-class="myForm.TrangThai.$invalid?'invalid form-group ':'form - group'">
                    <label>Trạng thái kích hoạt:</label>
                    <select class="form-control" ng-model="Album.TrangThai" name="TrangThai" ng-options="tt.MaThamSo as tt.DienGiai for tt in TrangThai" val-required>
                        <option value="">---Chọn trạng thái kích hoạt---</option>
                    </select>
                    <span ng-show="myForm.TrangThai.$error.valRequired" class="validate-text">Trạng thái là bắt buộc nhập</span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Ghi chú</label>
                    <textarea class="form-control" rows="5" ng-model="Album.GhiChu"></textarea>
                </div>
                <div class="col-md-6">
                    <div class="col-md-6">
                        <label>Ảnh tiêu đề:</label>
                        <input type="file" ng-model-instant onchange="angular.element(this).scope().imageChoose(event)" class="file">
                            <span ng-show="myForm.Image.$error.valRequired" class="validate-text">Ảnh tiêu đề là bắt buộc</span>
                        <a ng-show="!isEdit" href="#" class="btn btn-primary footer" role="button" ng-click="ThemAlbum()"><i class="fa fa-floppy-o"></i> Thêm Album  mới</a>
                        <a ng-show="isEdit" href="#" class="btn btn-primary footer" role="button" ng-click="CapNhat()"><i class="fa fa-floppy-o"></i> Lưu</a>
                        <a ng-show="isEdit" href="#" class="btn btn-default footer" role="button" ng-click="Huy()"><i class="fa fa-ban"></i> Hủy</a>
                    </div>
                    <div class="col-md-6">
                        <div ng-repeat="step in stepsModel">
                            <img class="thumb" ng-src="{{step}}" name="Image"/>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <div class="row"><hr>
            <form class="form-inline">
                <div class="form-group col-md-3">
                    <label >Tìm kiếm</label>
                    <input type="text" ng-model="search" class="form-control" placeholder="Tìm kiếm">
                </div>
                <div style="text-align: right;">
                    <dir-pagination-controls
                        max-size="5"
                        direction-links="true"
                        boundary-links="true" >
                    </dir-pagination-controls>
                </div>
            </form>
            <table id="example" class="table table-bordered table-hover table-striped table-hover">
                <thead>
                    <tr>
                    <th></th>
                    <th ng-click="sort('Id')" class="cursor">ID</th>
                    <th ng-click="sort('AnhTieuDe')" class="cursor"><i class="fa fa-sort"></i> Ảnh hiển thị</th>
                    <th ng-click="sort('TieuDe')" class="cursor "><i class="fa fa-sort"></i> Tên Album</th>
                    <th ng-click="sort('DanhMuc1')" class="cursor"><i class="fa fa-sort"></i> Khoa</th>
                    <th ng-click="sort('TrangThai1')" class="cursor"><i class="fa fa-sort"></i> Trạng thái</th>
                    <th ng-click="sort('GhiChu')" class="cursor"><i class="fa fa-sort"></i> Ghi chú</th>
                    <th ng-click="sort('NgayTao')" class="cursor"><i class="fa fa-sort"></i> Ngày tạo</th>
                    <th ng-click="sort('NgaySua')" class="cursor"><i class="fa fa-sort"></i> Ngày sửa</th>
                    <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr dir-paginate="al in TblAlbum|orderBy:sortKey:reverse|filter:search|itemsPerPage:5" ng-class="{select : $index == selectIndex}">
                    <td>
                        <input ng-model="al.Checked"  ng-true-value="1" ng-false-value="0" type="checkbox">
                    </td>
                    <td>{{al.Id}}</td>
                    <td><img src="../../Guest-Image/{{al.AnhTieuDe}}" class="ShowImage"/></td>
                    <td>{{al.TieuDe}}</td>
                    <td>{{al.DanhMuc1}}</td>
                    <td>{{al.TrangThai1}}</td>
                    <td>{{al.GhiChu}}</td>
                    <td>{{al.NgayTao}}</td>
                    <td>{{al.NgaySua}}</td>
                    <td style="padding: 5px 0px;"><a class="btn btn-danger" ng-click="XoaBanGhi(al.Id)"><i class="fa fa-trash"></i> Xóa</a>
                        <a class="btn btn-default" ng-click="SuaBanGhi(al.Id)"><i class="fa fa-pencil"></i> Sửa</a></td>
                    </tr>
                </tbody>
            </table>
            <a ng-click="XoaNhieuBanGhi()" class="btn btn-danger" role="button">Xóa bản ghi đã chọn</a>
        </div>
        <div id="Album-dialog-save" title="Thông báo">
            <p>
            <span class="ui-icon ui-icon-alert"
                  style="float: left; margin: 0 7px 20px 0;"></span>Lưu thành công
            </p>
        </div>
        <div id="Album-dialog-thongbao" title="Thông báo">
        </div>
    </div>    
    <script src="../../js/Album.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>