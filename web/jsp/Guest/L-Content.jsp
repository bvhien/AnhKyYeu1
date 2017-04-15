<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="content">
    <div id="new-albums">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/icon_image.png"></img>Album mới nhất</h3>
            </div>
        </div>
        <div class="clr"></div>
        <div id="slider1">
            <div id="album-content">
                <div class="slide-holder">
                    <div class="slide-pager">
                        <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                        <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                    </div>
                    <div class="slide-container">
                        <div class="slide-stage">
                            <div class="slide-image" ng-repeat=" TH in AlbumTH">
                                <img src="../../Guest-Image/{{TH.AlbumImage}}"></img>
                                <div class="title-image">
                                    <p>{{TH.AlbumTitle}}</p>
                                    <a href="Image.jsp?viewalbum={{TH.AlbumId}}" class="myButton">Xem chi tiết</a>
                                </div>
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
                        <div class="slide-image" ng-repeat=" cntt in AlbumCntt">
                            <img src="../../Guest-Image/{{cntt.AlbumImage}}"/>
                            <div class="title-image">
                                <p>{{cntt.AlbumTitle}}</p>
                                <a href="Image.jsp?viewalbum={{cntt.AlbumId}}" class="myButton">Xem chi tiết</a>
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
                        <div class="slide-image" ng-repeat=" ck in AlbumCk">
                            <img src="../../Guest-Image/{{ck.AlbumImage}}"/>
                            <div class="title-image">
                                <p>{{ck.AlbumTitle}}</p>
                                <a href="Image.jsp?viewalbum={{ck.AlbumId}}" class="myButton">Xem chi tiết</a>
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
                        <div class="slide-image" ng-repeat=" kt in AlbumKt">
                            <img src="../../Guest-Image/{{kt.AlbumImage}}"/>
                            <div class="title-image">
                                <p>{{kt.AlbumTitle}}</p>
                                <a href="Image.jsp?viewalbum={{kt.AlbumId}}" class="myButton">Xem chi tiết</a>
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
            <div class="r-handbook-content">
                <div class="list-item" ng-repeat=" cn in Handbook">
                    <img src="../../Guest-Image/{{cn.ArticleImage}}"></img>
                    <a href="#">{{cn.ArticleTitle}}</a>
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
            <div class="r-news">
                <div class="list-item" ng-repeat=" tt in Artile">
                    <img src="../../Guest-Image/{{tt.ArticleImage}}"></img>
                    <a href="#">{{tt.ArticleTitle}}</a>
                </div>
            </div>
        </div>

    </div>
</div>
<!--end content-->
