<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="r-content">
    <div id="view-news">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/newspaper.png"></img>Tin tức xem nhiều</h3>
            </div>
        </div>
        <div id="slider5">
            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev"><img src="../../Image/left.png"></img></div>
                    <div class="slide-control-next"><img src="../../Image/right.png"></img></div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image" ng-repeat=" av in ArticleVisited">
                            <div class="image">
                                <img src="../../Guest-Image/{{av.ArticleImage}}"/>
                            </div>
                            <div class="title-news">
                                <a href="ViewArticle.jsp?viewArticle={{av.ArticleId}}"><p>{{av.ArticleTitle}}</p></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div id="video">
        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/Video.png"></img>Video</h3>
            </div>
        </div>
        <div class="video">
            <iframe width="310" height="230" src="https://www.youtube.com/embed/sSgh6_FPFFg" frameborder="0" allowfullscreen>
            </iframe>
        </div>
    </div>

    <div id="facebook">

        <div class="title">
            <div class="tab">
                <h3><img src="../../Image/facebook.png"></img>Facebook</h3>
            </div>
        </div>
        <div class="facebook">
            <div id="fb-root"></div>
            <script>(function (d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id))
                        return;
                    js = d.createElement(s);
                    js.id = id;
                    js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8";
                    fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));</script>
            <div class="fb-page" data-href="https://www.facebook.com/DTLTBK/?fref=ts" data-tabs="timeline" data-width="310px" data-height="300px" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true"><blockquote cite="https://www.facebook.com/DTLTBK/?fref=ts" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/DTLTBK/?fref=ts">Viện Đào tạo liên tục -  ĐHBK Hà Nội</a></blockquote></div>
        </div>
    </div>
</div>
<div class="clr"></div>
<!--end r-content-->

