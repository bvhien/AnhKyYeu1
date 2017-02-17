<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
<div class="row">
    <h4 class="title">Quản lý bài viết</h4>
    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-condensed" id="example">
        <thead>
            <tr>
                <th>Rendering engine</th>
                <th>Noi Dung</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
            </tr>
        </thead>
        <tbody>
            <tr class="odd gradeX">
                <td>Trident</td>
                <td>Internet
                    Explorer 4.0</td>
                <td>Win 95+</td>
                <td class="center"> 4</td>
                <td class="center">X</td>
            </tr>
            <tr class="even gradeC">
                <td>Trident</td>
                <td>Internet
                    Explorer 5.0</td>
                <td>Win 95+</td>
                <td class="center">5</td>
                <td class="center">C</td>
            </tr>
            <tr class="odd gradeA">
                <td>Trident</td>
                <td>Internet
                    Explorer 5.5</td>
                <td>Win 95+</td>
                <td class="center">5.5</td>
                <td class="center">A</td>
            </tr>
            <tr class="even gradeA">
                <td>Trident</td>
                <td>Internet
                    Explorer 6</td>
                <td>Win 98+</td>
                <td class="center">6</td>
                <td class="center">A</td>
            </tr>
            <tr class="odd gradeA">
                <td>Trident</td>
                <td>Internet Explorer 7</td>
                <td>Win XP SP2+</td>
                <td class="center">7</td>
                <td class="center">A</td>
            </tr>
        </tbody>
    </table>
    <a href="#" class="btn btn-success" data-toggle="modal" data-target="#myModal" role="button">Thêm bản ghi mới</a>
    <a href="#" class="btn btn-danger" role="button">Xóa bản ghi đã chọn</a>
</div>
<jsp:include page="Footer.jsp"></jsp:include>