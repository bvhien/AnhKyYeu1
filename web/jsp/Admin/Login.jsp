<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../../js/Libjs/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular-route.min.js" type="text/javascript"></script>
        <script src="../../js/Login.js" type="text/javascript"></script>
        <script src="../../js/Validate.js" type="text/javascript"></script>
        <link href="../../css/Libcss/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Style.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Login.css" rel="stylesheet" type="text/css"/>
        <title>Đăng nhập</title>
    </head>
    <body id="Login" ng-app="app" ng-controller="Login">
        <form name="myForm">
            <div class="row">
                <div class="col-md-4 Login">
                    <h2 class="title">Đăng nhập</h2>
                    <div class="col-md-12 content text-right" ng-class="myForm.UserName.$invalid?'invalid form-group ':'form-group'">
                        <div class="col-md-4"><span class="control-label ">Tên đăng nhập</span ></div>
                        <div class="col-md-8" >
                            <input id="UserName" class="form-control" name="UserName" ng-model="Login.UserName" type="text" val-required>
                            <span ng-show="myForm.UserName.$error.valRequired" class="validate-text">Tên đăng nhập là bắt buộc</span>	
                        </div>
                    </div>
                    <div class="col-md-12 text-right" ng-class="myForm.PassWord.$invalid?'invalid form-group ':'form-group'">
                        <div class="col-md-4"><span class="control-label">Mật khẩu</span></div>
                        <div class="col-md-8">
                            <input class="form-control" name="PassWord" ng-model="Login.PassWord" type="password" val-required>
                            <span ng-show="myForm.PassWord.$error.valRequired" class="validate-text">Mật khẩu là bắt buộc</span>
                        </div>
                    </div>
                    <div class="col-md-12 text-center">
                        <span ng-show="errorLogin" class="validate-text text-center" style="color: red;">Tên đăng nhập hoặc mật khẩu không đúng</span><br/>
                        <a href="" ng-click="CheckLogin()" class="btn btn-success">Đăng nhập</a>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
