<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <script src="../js/AddImage.js" type="text/javascript"></script>
    <div ng-controller="AddImage">
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
                <label>Trạng thái kích hoạt:</label>
                <select class="form-control" >
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </div>
        </div>
        <!--    <div class="row form-upload-img">
                <div class="col-md-12">
                    <label for="files">Select multiple files: </label>
                    <input id="files" type="file" multiple/>
                    <output id="result" />
                </div>
            </div>-->
        <div ng-repeat="step in stepsModel">
            <img class="thumb" ng-src="{{step}}" />
        </div>

        <input type='file' ng-model-instant onchange="angular.element(this).scope().imageUpload(event)" multiple />
        <a href="" ng-click="Upload()">Upload</a>
    </div>
<jsp:include page="Footer.jsp"></jsp:include>