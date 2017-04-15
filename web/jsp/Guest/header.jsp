<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <script src="../../js/Libjs/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular.min.js" type="text/javascript"></script>
        <script src="../../js/Libjs/angular-route.min.js" type="text/javascript"></script>
        <!--<script src="../../js/Libjs/plugins_1.js" type="text/javascript"></script>-->
        <script type="text/javascript" charset="utf-8">
            var app = angular.module('app', ['ngRoute']);
            $(window).load(function () {
                Slider2();
                $("#slider2").responsiveSlides({
                    maxwidth: 1170,
                    speed: 800
                });
                Slider3();
                $("#slider3").responsiveSlides({
                    maxwidth: 1170,
                    speed: 800
                });
                Slider1();
                $("#slider1").responsiveSlides({
                    maxwidth: 1170,
                    speed: 800
                });
                Slider4();
                $("#slider4").responsiveSlides({
                    maxwidth: 1170,
                    speed: 800
                });
//                Slider5();
//                $("#slider5").responsiveSlides({
//                    maxwidth: 1170,
//                    speed: 800
//                });
            });
        </script>
        <script src="../../js/GuestJS/index.js" type="text/javascript"></script>
    </head>
    <body ng-app="app" ng-controller="Index">
        <% request.setCharacterEncoding("UTF-8");%>
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
                        <li><a href="index.jsp">Trang chủ</a></li>
                        <li><a href="">Tin tức</a>
                        </li>
                        <li><a href="Album.jsp?album=viewalbum">Hình ảnh</a></li>
                        <li><a href="">Cẩm nang</a></li>
                        <li>
                            <a href="">Giới thiệu</a>
                        </li>
                        <li><a href="">Liên hệ</a></li>
                    </ul>
                </div>
            </div>
            <!--end menu-->
