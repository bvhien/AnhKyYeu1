<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link href="../../css/index.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/slider1.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/Libcss/responsiveslides.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/Libjs/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular-route.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/custom.js" type="text/javascript"></script>
        <script src="../../js/Libjs/responsiveslides.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/baguetteBox.js" type="text/javascript"></script>
        <script src="../../js/Libjs/plugins.js" type="text/javascript"></script>
        <script>
            var app = angular.module('app', ['ngRoute']);
            $(function () {
//                $("#slider1").responsiveSlides({
//                    maxwidth: 1170,
//                    speed: 800
//                });
            });
        </script>
        <script src="../../js/GuestJS/index.js" type="text/javascript"></script>
    </head>
    <body ng-app="app" ng-controller="Index">
        <div id="main">
            <div class="header">
                <div id="bg-top">
                    <img src="../../Image/bg-top.png" alt=""/>
                </div>
                <div class="top">
                    <div class="l-top">
                        <a href="#" class="items"><img src="../../Image/phone.png" alt=""/></img></a>
                        <a href="#" class="items"><img src="../../Image//Email.png"></img></a>
                    </div>
                    <div class="r-top">
                        <a href="#"><img src="../../Image/google.png"></img></a>
                        <a href="#"><img src="../../Image/fb.png"></img></a>
                        <a href="#"><img src="../../Image/twitter.png"></img></a>
                        <a href="#"><img src="../../Image/yahoo.png"></img></a>
                        <a href="#"><img src="../../Image/youtube.png"></img></a>
                    </div>
                </div>
                <div class="baner">
                    <div class="logo">
                        <a href="#">
                            <img src="../../Image/fit-haui.png"></img>
                        </a>
                    </div>
                    <div class="search">
                        <form name="frmSearch" action="/home/Tim-kiem/">
                            <input type="text" placeholder="Nhập từ khóa tìm kiếm..."></input>
                            <button type="submit" class="btn-search"></button>
                        </form>
                    </div>
                    <div class="clr"></div>
                </div>
            </div>
            <!--end header-->
            <div class="menu">
                <div class="category">
                    <ul>
                        <li><a href="#">DANH MỤC<div id="ca-icon"><img src="../../Image/category.png"></img></div></a>
                            <ul>
                                <li><a href="">Khoa CNTT</a>
                                    <ul>
                                        <li>
                                            <a href="">Khóa 6</a>
                                        </li>
                                        <li>
                                            <a href="">Khóa 7</a>
                                        </li>
                                        <li><a href="">Khóa 13</a></li>
                                        <li><a href="">Khóa 14</a></li>
                                    </ul>
                                </li>
                                <li><a href="">Menu cấp 1</a></li>
                                <li><a href="">Menu cấp 1</a>
                                    <ul>
                                        <li><a href="">Menu cấp 2</a>
                                            <ul>
                                                <li><a href="">Menu cấp 3</a>
                                                </li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="">Menu cấp 2</a>
                                            <ul>
                                                <li><a href="">Menu cấp 3</a>

                                                </li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                                <li><a href="">Menu cấp 3</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="">Menu cấp 1</a></li>
                                <li><a href="">Menu cấp 1</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="nav">
                    <ul>
                        <li><a href="">Trang chủ</a></li>
                        <li><a href="">Tin tức</a>
                        </li>
                        <li><a href="">Hình ảnh</a></li>
                        <li><a href="">Cẩm nang</a></li>
                        <li>
                            <a href="">Giới thiệu</a>
                        </li>
                        <li><a href="">Liên hệ</a></li>
                    </ul>
                </div>
            </div>
            <!--end menu-->
