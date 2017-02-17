<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
                        <div class="slide-image">
                            <div class="image">
                                <img src="layout/pictures/1.jpg"/>
                            </div>
                            <div class="title-news">
                                <a href="#"><p>T\u1EEB n\u01A1i \u0111�y, bao th\u1EBF h\u1EC7 h\u1ECDc sinh, sinh vi�n (HSSV) \u0111� ra tr\u01B0\u1EDDng</p></a>
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
            <iframe width="310" height="230" src="https://www.youtube.com/embed/TozBh1fp9gA" frameborder="0" allowfullscreen>
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
            <%
                out.print("<script src=\"//connect.facebook.net/vi_VN/sdk.js#xfbml=1&amp;version=v2.5\" id=\"facebook-jssdk\"></script>");
                out.print("<script>(function(d, s, id) {");
                out.print("var js, fjs = d.getElementsByTagName(s)[0];");
                out.print("if (d.getElementById(id)) return;");
                out.print("js = d.createElement(s); js.id = id;");
                out.print("js.src = \"//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5\";");
                out.print("fjs.parentNode.insertBefore(js, fjs);");
                out.print("}(document, 'script', 'facebook-jssdk'));</script>");
            %>
            <iframe style="border: medium none; visibility: visible; height: 230px; width: 310px;padding:0px;" class="" src="http://www.facebook.com/v2.0/plugins/like_box.php?app_id=1512160065690010&amp;channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D42%23cb%3Df126e31de89d8ac%26domain%3Dmotchangduong.net%26origin%3Dhttp%253A%252F%252Fmotchangduong.net%252Ff35b59ccab7164%26relation%3Dparent.parent&amp;color_scheme=light&amp;container_width=310&amp;header=true&amp;href=https%3A%2F%2Fwww.facebook.com%2Fhaui.fit.alumni&amp;locale=vi_VN&amp;sdk=joey&amp;show_border=true&amp;show_faces=true&amp;stream=false&amp;width=310" title="fb:like_box Facebook Social Plugin" scrolling="no" allowfullscreen="true" allowtransparency="true" name="f3cd2bf496dbc26" frameborder="0" height="1000px" width="310px"></iframe>

        </div>
    </div>
</div>
<div class="clr"></div>
<!--end r-content-->

