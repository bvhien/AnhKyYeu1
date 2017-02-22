<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <div>
        <div class="row">
            <h4 class="title">Quản lý Ảnh</h4>
            <div class=" col-md-3">
                <label>Chọn Album:</label>
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
            <div class=" col-md-3">
                <input style="margin-top: 25px;" type="file" ng-model-instant onchange="angular.element(this).scope().imageChoose(event)" class="file" multiple>
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
                    <a class="ckImage btn fa fa-times-circle" href="" ng-click="ClearImage($index)"></a>
                    <img class="multipleImage" ng-src="{{itemImage}}" />
                </div>
            </div>
        </div>
    </div>
    <script src="../../js/Image.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"></jsp:include>