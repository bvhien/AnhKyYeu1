<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <div>
        <div class="row">
            <h4 class="title"><i class="fa fa-link"></i>Tham số hệ thống</h4>
            <div id="home" class="tab-pane fade in active">
                <div class="row">
                    <div class="col-md-6" ng-class="myForm.TenThamSo.$invalid?'invalid form-group ':'form - group'">
                        <div class="col-md-3 text-right"><label class="control-label"><span>* </span>Tên tham số:</label></div>
                        <div class="col-md-9">
                            <input type="text" class="form-control" ng-model="ThamSo.TenThamSo" name="TenThamSo" id="TenThamSo" val-required capitalize>
                            <span ng-show="myForm.TenThamSo.$error.valRequired" class="validate-text">Tên tham số là bắt buộc nhập</span>	
                        </div>				                		
                    </div>
                    <div class="col-md-6" ng-class="myForm.MaThamSo.$invalid?'invalid form-group ':'form - group'">
                        <div class="col-md-3 text-right"><label class="control-label"><span>* </span>Mã tham số:</label></div>
                        <div class="col-md-9">
                            <input type="text" class="form-control" ng-model="ThamSo.MaThamSo" name="MaThamSo" val-required capitalize>
                            <span ng-show="myForm.MaThamSo.$error.valRequired" class="validate-text">Mã tham số là bắt buộc nhập</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" ng-class="myForm.TrangThai.$invalid?'invalid form-group ':'form - group'">
                        <div class="col-md-3 text-right"><label class="control-label"><span>* </span>Trạng thái:</label></div>
                        <div class="col-md-9">
                            <select class="form-control" ng-model="ThamSo.TrangThai" name="TrangThai" val-required>
                                <option value="">---Chọn trạng thái kích hoạt---</option>
                                <option value="1">Kích hoạt</option>
                                <option value="0">Không kích hoạt</option>
                            </select>
                            <span ng-show="myForm.TrangThai.$error.valRequired" class="validate-text">Trạng thái là bắt buộc chọn</span>
                        </div>
                    </div>
                    <div class="col-md-6" ng-class="myForm.DienGiai.$invalid?'invalid form-group ':'form - group'">
                        <div class="col-md-3 text-right"><label class="control-label"><span>* </span>Diễn giải:</label></div>
                        <div class="col-md-9">
                            <input type="text" class="form-control" ng-model="ThamSo.DienGiai" name="DienGiai" val-required>
                            <span ng-show="myForm.DienGiai.$error.valRequired" class="validate-text">Diễn giải là bắt buộc nhập</span>
                        </div>
                    </div>
                    <div class="col-md-12 text-right">
                        <a ng-show="!isEdit" href="" ng-click="ThemThamSo()" class="btn btn-primary btn-function"><i class="fa fa-floppy-o"></i> Thêm mới</a>
                        <a ng-show="isEdit" href="" ng-click="CapNhatThamSo()" class="btn btn-primary btn-function"><i class="fa fa-floppy-o"></i> Lưu</a>
                        <a ng-show="isEdit" href="" ng-click="Huy()" class="btn btn-default btn-function"><i class="fa fa-ban"></i> Hủy</a>
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
                    <table class="table table-bordered table-hover table-striped table-hover">
                        <thead>
                            <tr>
                            <th></th>
                            <th ng-click="sort('Id')" class="cursor">ID</th>
                            <th ng-click="sort('MaThamSo')" class="cursor"><i class="fa fa-sort"></i> Mã tham số</th>
                            <th ng-click="sort('TenThamSo')" class="cursor "><i class="fa fa-sort"></i> Giá trị</th>
                            <th ng-click="sort('DienGiai')" class="cursor"><i class="fa fa-sort"></i> Diễn giải</th>
                            <th ng-click="sort('TrangThai')" class="cursor"><i class="fa fa-sort"></i> Trạng thái</th>
                            <th ng-click="sort('NgayTao')" class="cursor"><i class="fa fa-sort"></i> Ngày tạo</th>
                            <th ng-click="sort('NgaySua')" class="cursor"><i class="fa fa-sort"></i> Ngày sửa</th>
                            <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr dir-paginate="ts in TableThamSo|orderBy:sortKey:reverse|filter:search|itemsPerPage:5" ng-class="{select : $index == selectIndex}">
                            <td>
                                <input ng-model="ts.Checked"  ng-true-value="1" ng-false-value="0" type="checkbox">
                            </td>
                            <td>{{ts.Id}}</td>
                            <td>{{ts.MaThamSo}}</td>
                            <td>{{ts.TenThamSo}}</td>
                            <td>{{ts.DienGiai}}</td>
                            <td ng-show="ts.TrangThai == 1">Kích hoạt</td>
                            <td ng-show="ts.TrangThai == 0">Không kích hoạt</td>
                            <td>{{ts.NgayTao}}</td>
                            <td>{{ts.NgaySua}}</td>
                            <td style="padding: 5px 0px;"><a class="btn btn-danger" ng-click="XoaBanGhi($index)"><i class="fa fa-trash"></i> Xóa</a>
                            <a class="btn btn-default" ng-click="SuaBanGhi($index)"><i class="fa fa-pencil"></i> Sửa</a></td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="#" class="btn btn-danger" role="button" ng-click="XoaNhieuBanGhi()">Xóa bản ghi đã chọn</a>
                </div>
            </div>

            <!--Dialog-->

            <div id="Thamso-dialog-save" title="Thông báo">
                <p>
                <span class="ui-icon ui-icon-alert"
                      style="float: left; margin: 0 7px 20px 0;"></span>Lưu thành công
                </p>
            </div>
            <div id="Thamso-dialog-thongbao" title="Thông báo">
            </div>
            <!--end tab conten-->
        </div>
    </div>
    <script src="../../js/ThamSo.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>