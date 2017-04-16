<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<jsp:include page="header.jsp"></jsp:include>
    <div id="content-title">
        <div class="title">
            <div class="tab">
                <h3><a href="index.jsp">Trang chủ</a> > <a href="Album.jsp?album=viewalbum">Album</a> > {{articleName.articleName}}</h3>
            </div>
        </div>
        <div id="shows-image">
            <div class="masonry">
                <div id="content">
                    <div class="baguetteBoxOne gallery">
                        <div class="item" ng-repeat="list in ListImage"><a href="../../Guest-Image/{{list.ImageUrl}}"><img src="../../Guest-Image/{{list.ImageUrl}}" /></a></div>
<!--                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>
                        <div class="item"><a href="../../Guest-Image/1490895663498.png"><img src="../../Guest-Image/1490895663498.png" /></a></div>-->
                        
                        
                    </div>
                </div>
            </div>		
            <script>
                window.onload = function () {
                    if (typeof oldIE === 'undefined' && Object.keys)
                        hljs.initHighlighting();
                    baguetteBox.run('.baguetteBoxOne');

                };
            </script>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>
