<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <div>
        <div class="row">
            <h4 class="title"><i class="fa fa-link"></i>Quản lý người dùng</h4>
            <div id="home" class="tab-pane fade in active">
                <div class="row">
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
                            <th ng-click="sort('UserName')" class="cursor"><i class="fa fa-sort"></i> UserName</th>
                            <th ng-click="sort('UserFullName')" class="cursor "><i class="fa fa-sort"></i> Tên</th>
                            <th ng-click="sort('UserBirthday')" class="cursor"><i class="fa fa-sort"></i> Ngày sinh</th>
                            <th ng-click="sort('UserMobilePhone')" class="cursor"><i class="fa fa-sort"></i> Số ĐT</th>
                            <th ng-click="sort('UserEmail')" class="cursor"><i class="fa fa-sort"></i> Email</th>
                            <th ng-click="sort('UserPermission')" class="cursor"><i class="fa fa-sort"></i> Quyền</th>
                            <th ng-click="sort('UserStatus')" class="cursor"><i class="fa fa-sort"></i> Trạng thái</th>
                            <!--                            <th ng-click="sort('userCreatedDate')" class="cursor"><i class="fa fa-sort"></i> Ngày tạo</th>
                                                        <th ng-click="sort('userEditedDate')" class="cursor"><i class="fa fa-sort"></i> Ngày sửa</th>-->
                            <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr dir-paginate="user in TableUser|orderBy:sortKey:reverse|filter:search|itemsPerPage:5" ng-class="{select : $index == selectIndex}">
                            <td>
                                <input ng-model="user.Checked"  ng-true-value="1" ng-false-value="0" type="checkbox">
                            </td>
                            <td>{{user.UserName}}</td>
                            <td style="max-width: 200px;">{{user.UserFullName}}</td>
                            <td style="max-width: 150px;">{{user.UserBirthday}}</td>
                            <td>{{user.UserMobilePhone}}</td>
                            <td>{{user.UserEmail}}</td>
                            <td>{{user.UserPermission}}</td>
                            <td>{{user.UserStatus}}</td>
                            <!--                            <td>{{user.userCreatedDate}}</td>
                                                        <td>{{user.userEditedDate}}</td>-->
                            <td style="padding: 5px 0px;">
                                <!--<a class="btn btn-danger" ng-click="DoiMatKhau(user.Id)"> Đổi MK</a>-->
                                <a class="btn btn-warning" ng-click="ShowPopupSua(user.Id)"><i class="fa fa-pencil"></i> Sửa</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div><hr>
                <div class="row">
                    <div class="col-md-2"><a class="btn btn-primary" ng-click="ShowPopupThem()">Thêm tài khoản</a></div>
                    <div class="col-md-2"><a class="btn btn-danger " ng-click="Xoa()">Xóa tài khoản</a></div>
                </div>
            </div>
        </div>
        <div id="User-dialog-save" title="Thông báo">
            <p>
            <span class="ui-icon ui-icon-alert"
                  style="float: left; margin: 0 7px 20px 0;"></span>Lưu thành công
            </p>
        </div>
        <div id="User-dialog-thongbao" title="Thông báo">
        </div>

        <!--Popup thêm mới User-->
        <form name="Add">
            <div id="Them-User" name="Add" title="Thêm mới User">
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Add.UserName.$invalid?'invalid form-group ':'form - group'">
                        <label>Tên đăng nhập:</label>
                        <input placeholder="Nhập tên đăng nhập" type="text" class="form-control" ng-model="User.UserName" name="UserName" id="UserName" val-required>
                        <span ng-show="myForm.Add.UserName.$error.valRequired" class="validate-text">Tên đăng nhập là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-6" ng-class="myForm.Add.UserPass.$invalid?'invalid form-group ':'form - group'">
                        <label>Mật khẩu:</label>
                        <input type="password" placeholder="Nhập số mật khẩu" class="form-control" ng-model="User.UserPass" name="UserPass" val-required >
                        <span ng-show="myForm.Add.UserPass.$error.valRequired" class="validate-text">Mật khẩu là bắt buộc nhập</span>
                    </div>
                </div>
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Add.UserFullName.$invalid?'invalid form-group ':'form - group'">
                        <label>Tên đầy đủ:</label>
                        <input type="text" placeholder="Nhập tên đầy đủ" class="form-control" ng-model="User.UserFullName" name="UserFullName" val-required>
                        <span ng-show="myForm.Add.UserFullName.$error.valRequired" class="validate-text">Tên là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-6" ng-class="myForm.Add.UserBirthday.$invalid?'invalid form-group ':'form - group'">
                        <label>Ngày sinh:</label>
                        <input type="text" placeholder="Nhập ngày sinh" class="form-control datepicker" ng-model="User.UserBirthday" name="UserBirthday" val-required >
                        <span ng-show="myForm.Add.UserBirthday.$error.valRequired" class="validate-text">Ngày sinh là bắt buộc nhập</span>
                    </div>
                </div>
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Add.UserMobilePhone.$invalid?'invalid form-group ':'form - group'">
                        <label>Số điện thoại:</label>
                        <input placeholder="Nhập số điện thoại" type="text" class="form-control" ng-model="User.UserMobilePhone" name="UserMobilePhone" val-required numbers-only>
                        <span ng-show="myForm.Add.UserMobilePhone.$error.valRequired" class="validate-text">Số điện thoại là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-6" ng-class="myForm.Add.UserEmail.$invalid?'invalid form-group ':'form - group'">
                        <label>Email:</label>
                        <input type="email" placeholder="Nhập địa chỉ email" class="form-control" ng-model="User.UserEmail" name="UserEmail" val-required>
                        <span ng-show="myForm.Add.UserEmail.$error.valRequired" class="validate-text">Email là bắt buộc nhập</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" ng-class="myForm.Add.UserPermission.$invalid?'invalid form-group ':'form - group'">
                        <label>Quyền tài khoản:</label>
                        <select  class="form-control" ng-model="User.UserPermission" name="UserPermission" ng-options="pm.MaThamSo as pm.DienGiai for pm in Permiss" val-required>
                            <option value="">---Chọn quyền tài khoản---</option>
                        </select>
                        <span ng-show="myForm.Add.UserPermission.$error.valRequired" class="validate-text">Quyền tài khoản là bắt buộc chọn</span>
                    </div>
                    <div class="col-md-6" ng-class="myForm.Add.UserStatus.$invalid?'invalid form-group ':'form - group'">
                        <label>Trạng thái kích hoạt:</label>
                        <select class="form-control" ng-model="User.UserStatus" name="UserStatus" ng-options="TT.MaThamSo as TT.DienGiai for TT in TrangThai" val-required>
                            <option value="">---Chọn trạng thái---</option>
                        </select>
                        <span ng-show="myForm.Add.UserStatus.$error.valRequired" class="validate-text">Trạng thái là bắt buộc chọn</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <a style="color: white !important;" class="btn btn-primary btn-function" ng-click="ThemUser()"><i class="fa fa-floppy-o"></i> Lưu</a>
                        <a style="color: white !important;" class="btn btn-danger btn-function" ng-click="ClosePopupThem()"><i class="fa fa-ban"></i> Hủy</a>
                    </div>
                </div>
            </div>
        </form>



        <!--Popup sửa User-->
        <form name="Edit">
            <div id="Sua-User" title="Thêm mới User">
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Edit.ChangeUserName.$invalid?'invalid form-group ':'form - group'">
                        <label>Tên đăng nhập:</label>
                        <input ng-readonly="true" placeholder="Nhập tên đăng nhập" type="text" class="form-control" ng-model="ChangeUser.UserName" name="ChangeUserName" id="UserName" val-required>
                        <span ng-show="myForm.Edit.ChangeUserName.$error.valRequired" class="validate-text">Tên đăng nhập là bắt buộc nhập</span>
                    </div>
                    <div class="col-md-6" ng-class="myForm.Edit.ChangeUserPermission.$invalid?'invalid form-group ':'form - group'">
                        <label>Quyền tài khoản:</label>
                        <select  class="form-control" ng-model="ChangeUser.UserPermission" name="ChangeUserPermission" ng-options="pm.MaThamSo as pm.DienGiai for pm in Permiss" val-required>
                            <option value="">---Chọn quyền tài khoản---</option>
                        </select>
                        <span ng-show="myForm.Edit.ChangeUserPermission.$error.valRequired" class="validate-text">Quyền tài khoản là bắt buộc chọn</span>
                    </div>
                </div>
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Edit.ChangeUserFullName.$invalid?'invalid form-group ':'form - group'">
                        <label>Tên đầy đủ:</label>
                        <input type="text" placeholder="Nhập tên đầy đủ" class="form-control" ng-model="ChangeUser.UserFullName" name="ChangeUserFullName" val-required>
                        <span ng-show="myForm.Edit.ChangeUserFullName.$error.valRequired" class="validate-text">Tên là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-6" ng-class="myForm.Edit.ChangeUserBirthday.$invalid?'invalid form-group ':'form - group'">
                        <label>Ngày sinh:</label>
                        <input type="text" placeholder="Nhập ngày sinh" class="form-control datepicker" ng-model="ChangeUser.UserBirthday" name="ChangeUserBirthday" val-required >
                        <span ng-show="myForm.Edit.ChangeUserBirthday.$error.valRequired" class="validate-text">Ngày sinh là bắt buộc nhập</span>
                    </div>
                </div>
                <div class="row">
                    <div class=" col-md-6" ng-class="myForm.Edit.ChangeUserMobilePhone.$invalid?'invalid form-group ':'form - group'">
                        <label>Số điện thoại:</label>
                        <input placeholder="Nhập số điện thoại" type="text" class="form-control" ng-model="ChangeUser.UserMobilePhone" name="ChangeUserMobilePhone" val-required numbers-only>
                        <span ng-show="myForm.Edit.ChangeUserMobilePhone.$error.valRequired" class="validate-text">Số điện thoại là bắt buộc nhập</span>
                    </div>
                    <div class=" col-md-6" ng-class="myForm.Edit.ChangeChangeUserEmail.$invalid?'invalid form-group ':'form - group'">
                        <label>Email:</label>
                        <input type="email" placeholder="Nhập địa chỉ email" class="form-control" ng-model="ChangeUser.UserEmail" name="ChangeUserEmail" val-required>
                        <span ng-show="myForm.Edit.ChangeUserEmail.$error.valRequired" class="validate-text">Email là bắt buộc nhập</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" ng-class="myForm.Edit.ChangeUserStatus.$invalid?'invalid form-group ':'form - group'">
                        <label>Trạng thái kích hoạt:</label>
                        <select class="form-control" ng-model="ChangeUser.UserStatus" name="ChangeUserStatus" ng-options="TT.MaThamSo as TT.DienGiai for TT in TrangThai" val-required>
                            <option value="">---Chọn trạng thái---</option>
                        </select>
                        <span ng-show="myForm.Edit.ChangeUserStatus.$error.valRequired" class="validate-text">Trạng thái là bắt buộc chọn</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <a style="color: white !important;" class="btn btn-primary btn-function" ng-click="SuaUser()"><i class="fa fa-floppy-o"></i> Lưu</a>
                        <a style="color: white !important;" class="btn btn-danger btn-function" ng-click="ClosePopupSua()"><i class="fa fa-ban"></i> Hủy</a>
                    </div>
                </div>
            </div>
        </form>

    </div>
    <script src="../../js/User.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>
