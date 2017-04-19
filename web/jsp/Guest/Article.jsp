<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<jsp:include page="header.jsp"></jsp:include>

    <div id="content-title">
        <div class="title">
            <div class="tab">
                <h3><a href="index.jsp">Trang chủ</a> > {{SectionName.SectionName}}</h3>
            </div>
        </div>
        <div class="Article" ng-repeat="AbyS in ListArticleBySection">
            <div>
                <div style="width: 100px;float: left; max-height: 100px;">
                    <img style="width: 100%;height: 100%;" src="../../Guest-Image/{{AbyS.ArticleImage}}"></img>
                </div>
                <div style="width: 750px; float: right;">
                    <a style="margin-left: 10px;font-weight: bold;color: black;" href="ViewArticle.jsp?viewArticle={{AbyS.ArticleId}}">{{AbyS.ArticleTitle}}</a>
                    <p>{{AbyS.ArticleSummary}}</p>
                </div>
                <div style="clear: both;"></div>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
