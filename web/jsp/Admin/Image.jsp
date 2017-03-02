<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <div>
        <div class="row">
            <h4 class="title">Quản lý Ảnh</h4>
            <div class=" col-md-3">
                <label>Chọn Khoa:</label>
                <select class="form-control" ng-model="Image.CategoryId" ng-options="c.CategoryId as c.CategoryName for c in Category" ng-change="LayDSAlbum(Image.CategoryId)"></select>
            </div>
            <div class=" col-md-3">
                <label>Chọn Album:</label>
                <select class="form-control" ng-model="Image.AlbumId" ng-options="a.AlbumId as a.AlbumName for a in Album" ng-change="LayDSAnh(Image.AlbumId)"></select>
            </div>
            <div class=" col-md-3">
                <input style="margin-top: 25px;" type="file" ng-model-instant onchange="angular.element(this).scope().imageChoose(event)" class="file" multiple>
            </div>
            <div class="col-md-3">
                <a class="btn btn-info btn-function" ng-click="ThemImage(Image.CategoryId,Image.AlbumId)">Thêm ảnh</a>
            </div>
        </div>
        <div class="row ImageContainer" ng-show="stepsModel.length > 0">
            <div ng-repeat="step in stepsModel" class="ImtemImage" ng-class="{select : $index == selectIndex}">
                <a class="ckImage btn fa fa-times-circle" href="" ng-click="ClearImage($index)"></a>
                <img class="multipleImage" ng-src="{{step}}" />
            </div>
        </div>
        <div class="row" style="margin-top: 20px;">
            <h4>Album ảnh</h4>
            <div class="row ImageContainer" ng-show="AlbumImage.length > 0">
                <div ng-repeat="itemImage in AlbumImage" class="ImtemImage">
                    <a class="ckImage btn fa fa-times-circle" href="" ng-click="DeleteImage(itemImage.imageId,itemImage.imageUrl)"></a>
                    <img class="multipleImage" ng-src="../../Guest-Image/{{itemImage.imageUrl}}" />
                </div>
            </div>
        </div>

        <!--Dialog-->

        <div id="Image-dialog-save" title="Thông báo">
            <p>
            <span class="ui-icon ui-icon-alert"
                  style="float: left;"></span>Lưu thành công
            </p>
        </div>
        <div id="Image-dialog-thongbao" title="Thông báo"></div>
    </div>
    <script src="../../js/Image.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>