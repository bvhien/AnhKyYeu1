<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<jsp:include page="header.jsp"></jsp:include>

<div id="content-title">
    <div class="title">
        <div class="tab">
            <h3><a href="index.jsp">Trang chủ</a> > {{GetArticle.SectionName}}</h3>
        </div>
    </div>
    <div class="Article">
        <div class="TitleArticle">
            <p>{{GetArticle.ArticleTitle}}</p>
        </div>
        <div class="SummaryArticle">
            <p>{{GetArticle.ArticleSummary}}</p>
        </div>
        <div class="ContentArticle" >
            <p id="ContentArticle"></p>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
