<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Quản trị hệ thống</title>
        <!--Css-->
        <link href="../../css/Libcss/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/sb-admin.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/editor.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Style.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery Version 1.11.0 -->
        <script src="../../js/Libjs/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular-route.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/jquery-ui.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/jquery.ui.datepicker-vi.js" type="text/javascript"></script>
        <script src="../../js/Libjs/UTF-8.js" type="text/javascript"></script>
        <script src="../../js/Libjs/editor.js" type="text/javascript"></script>
        <!--<script src="../js/Libjs/jquery.dataTables.js" type="text/javascript"></script>-->
        <!--<script src="../js/Libjs/dataTables.bootstrap.js" type="text/javascript"></script>-->
        <script src="../../js/Libjs/dirPagination.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf-8">
//            var app = angular.module('app',['angularUtils.directives.dirPagination']);
//            var app = angular.module('app', ['ngRoute']).directive('capitalize', function () {
            var app = angular.module('app', ['angularUtils.directives.dirPagination']).directive('capitalize', function () {
                return {
                    require: 'ngModel',
                    link: function (scope, element, attrs, modelCtrl) {
                        var capitalize = function (inputValue) {
                            if (inputValue == undefined)
                                inputValue = '';
                            var capitalized = inputValue.toUpperCase();
                            if (capitalized !== inputValue) {
                                modelCtrl.$setViewValue(capitalized);
                                modelCtrl.$render();
                            }
                            return capitalized;
                        }
                        modelCtrl.$parsers.push(capitalize);
                        capitalize(scope[attrs.ngModel]); // capitalize initial value
                    }
                };
            });
            $(document).ready(function () {
                var url = window.location.href;
                $('.navbar-nav li').each(function () {
                    console.log(this.firstElementChild.href);
                    if (url === (this.firstElementChild.href)) {
                        $(this).addClass('active');
                    }
                });


                //                $('#example').DataTable();
                $("#txtEditor").Editor();
                List();
                $(function () {
                    $(".datepicker").datepicker({changeMonth: true, changeYear: true, dateFormat: 'dd/mm/yy', yearRange: '-70y:+70y'});
                    ;
                });
            });
        </script>
        <script src="../../js/Validate.js" type="text/javascript"></script>
        <script src="../../js/CheckLogin.js" type="text/javascript"></script>
    </head>

    <body ng-app="app">

        <form id="wrapper"  name="myForm" ng-controller="Ctrl" >
            <% request.setCharacterEncoding("UTF-8");%>
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Quản trị hệ thống</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <!--                    <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                                            <ul class="dropdown-menu message-dropdown">
                                                <li class="message-preview">
                                                    <a href="#">
                                                        <div class="media">
                                                            <span class="pull-left">
                                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                                            </span>
                                                            <div class="media-body">
                                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                                </h5>
                                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="message-preview">
                                                    <a href="#">
                                                        <div class="media">
                                                            <span class="pull-left">
                                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                                            </span>
                                                            <div class="media-body">
                                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                                </h5>
                                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="message-preview">
                                                    <a href="#">
                                                        <div class="media">
                                                            <span class="pull-left">
                                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                                            </span>
                                                            <div class="media-body">
                                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                                </h5>
                                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="message-footer">
                                                    <a href="#">Read All New Messages</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                                            <ul class="dropdown-menu alert-dropdown">
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                                                </li>
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                                                </li>
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                                                </li>
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                                                </li>
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                                                </li>
                                                <li>
                                                    <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                                                </li>
                                                <li class="divider"></li>
                                                <li>
                                                    <a href="#">View All</a>
                                                </li>
                                            </ul>
                                        </li>-->
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>&nbsp;<b id="ThongTinTK"></b><b class="caret">&nbsp;</b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#" onclick="DangXuat()
                                            ;"><i class="fa fa-fw fa-power-off"></i> Đăng xuất</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="Thamso.jsp"><i class="fa fa-fw fa-link"></i> Tham số</a>
                        </li>
                        <li>
                            <a href="Album.jsp"><i class="fa fa-fw fa-folder-open-o"></i> Album</a>
                        </li>
                        <li>
                            <a href="Image.jsp"><i class="fa fa-fw fa-picture-o"></i> Image</a>
                        </li>
                        <li>
                            <a href="User.jsp"><i class="fa fa-fw fa-user-circle"></i> Người dùng</a>
                        </li>
                        <li>
                            <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                        </li>
                        <li>
                            <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="#">Dropdown Item</a>
                                </li>
                                <li>
                                    <a href="#">Dropdown Item</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
