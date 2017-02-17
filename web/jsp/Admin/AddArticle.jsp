<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
<div class="row">
        <h4 class="title">Thêm bài viết</h4>
        <div class=" col-md-3">
            <label>Chọn chuyên mục:</label>
            <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select>
        </div>
        <div class=" col-md-3">
            <label>Trạng thái:</label>
            <select class="form-control" >
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select>
        </div>
        <div class=" col-md-3">
            <label>Sắp xếp:</label>
            <input type="number" class="form-control">
        </div>
        <div class="row">
            <div class="col-lg-9">
                <label>Tiêu đề:</label>
                <input type="text" class="form-control">
            </div>
            <div class="col-lg-10 nopadding">
                <label style="margin-left:20px;">Nhập nội dung:</label>
                <textarea class="text-editor" id="txtEditor"></textarea> 
            </div>
        </div>
        <div class="row btn-function">
            <a href="#" class="btn btn-primary" role="button">Lưu</a>&nbsp;
            <a href="#" class="btn btn-primary" role="button">Hủy</a>
        </div>
    </div>
<jsp:include page="Footer.jsp"></jsp:include>