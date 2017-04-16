<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<jsp:include page="header.jsp"></jsp:include>
<div id="content-title">
    <div class="title">
        <div class="tab">
            <h3><a href="index.jsp">Trang chủ</a> > Album</h3>
        </div>
    </div>
    <div id="shows-image">
        <div class="album-image" ng-repeat="list in ListAlbum">
            <img src="../../Guest-Image/{{list.AlbumImage}}"/>
            <div class="title-image">
                <p>{{list.AlbumTitle}}</p>
                <a href="Image.jsp?viewalbum={{list.AlbumId}}" class="myButton">Xem chi tiết</a>
            </div>									
        </div>						
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>