<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<div class="content">
    <div id="new-albums">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/icon_image.png"></img>Album mới nhất</h3>
            </div>
        </div>
        <div class="clr"></div>
        <div id="album-content">
            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                    <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image" ng-repeat=" cntt in AlbumCntt">
                            <img src="{{cntt.AlbumImage}}"></img>
                            <div class="title-image">
                                <p>{{cntt.AlbumTitle}}</p>
                                <a href="/{{cntt.AlbumId}}" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="khoacntt">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/icon_image.png"></img>Album khoa CNTT</h3>
            </div>
        </div>

        <div id="slider2">
            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                    <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image">
                            <img src="pictures/1.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/2.jpg"/>
                            <div class="title-image">
                                <p>gwjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/3.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="pictures/4.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="clr"></div>

    <div id="khoacokhi">

        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/icon_image.png"></img>Album khoa cơ khí</h3>
            </div>
        </div>

        <div id="slider3">
            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                    <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image">
                            <img src="layout/pictures/1.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/3.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/4.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>

                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="clr"></div>
    <div id="khoakt">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/icon_image.png"></img>Album khoa KT-KT</h3>
            </div>
        </div>
        <div class="clr"></div>

        <div id="slider4">
            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                    <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image">
                            <img src="layout/pictures/1.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/2.jpg"/>
                            <div class="title-image">
                                <p>gwjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/3.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/4.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                        <div class="slide-image">
                            <img src="layout/pictures/5.jpg"/>
                            <div class="title-image">
                                <p>gjhgishgise</p>
                                <a href="#" class="myButton">Xem chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>



    <div id="handbook">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/handbook.png"></img>Cẩm nang</h3>
            </div>
        </div>
        <div class="clr"></div>

        <div id="handbook-content">
            <div class="l-handbook-content">
                <img src="layout/pictures/1.jpg"></img>
                <a href="#">T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</a>
            </div>
            <div class="r-handbook-content">
                <div class="list-item">
                    <img src="layout/pictures/1.jpg"></img>
                    <a href="#">T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</a>
                </div>

            </div>
        </div>

    </div>

    <div id="news">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/news.png"></img>Tin tức</h3>
            </div>
        </div>
        <div class="clr"></div>

        <div id="news-content">
            <div class="l-news">
                <div class="main-news">
                    <img src="layout/pictures/1.jpg"></img>
                    <a href="#">T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</a>
                </div>
                <div class="main-news">
                    <img src="layout/pictures/1.jpg"></img>
                    <a href="#">T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</a>
                </div>
            </div>

            <div class="r-news">
                <ul>
                    <a href="#"><li>T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</li></a>
                    <a href="#"><li>T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</li></a>
                    <a href="#"><li>T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</li></a>
                </ul>
            </div>
        </div>

    </div>
</div>
<!--end content-->
