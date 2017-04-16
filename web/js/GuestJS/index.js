app.controller('Index', function ($scope) {
    $(document).ready(function () {
        $scope.LayThongTin();
        if ($scope.getParameterByName('album') != null) {
            $scope.LayThongTinAlbum();
        }
        if ($scope.getParameterByName('viewalbum') != null) {
            $scope.LayThongTinImage($scope.getParameterByName('viewalbum'));
        }
        if ($scope.getParameterByName('viewArticle') != null) {
            $scope.LayThongTinArticle($scope.getParameterByName("viewArticle"))
        }
    });
    $scope.getParameterByName = function (name) {
        url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                results = regex.exec(url);
        if (!results)
            return null;
        if (!results[2])
            return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }

    $scope.LayThongTinArticle = function (IdArticle) {
        $.ajax({
            url: "../../Index",
            type: 'GET',
            data: {
                type: "LayThongTinArticle",
                data: IdArticle
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.GetArticle = resp.GetArticle[0];
                        document.getElementById('ContentArticle').innerHTML = $scope.GetArticle.ArticleContent;
                    }
                });
            }
        });
    }

    $scope.LayThongTinAlbum = function () {
        $.ajax({
            url: "../../Index",
            type: 'GET',
            data: {
                type: "LayThongTinAlbum",
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.ListAlbum = resp.ListAlbum;
                    }
                });
            }
        });
    }

    $scope.LayThongTinImage = function (IdAlbum) {
        $.ajax({
            url: "../../Index",
            type: 'GET',
            data: {
                type: "LayThongTinImage",
                data: IdAlbum
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.ListImage = resp.ListImage;
                        $scope.articleName = resp.TitleAlbum[0];
                    }
                });
            }
        });
    }
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Index",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.AlbumTH = resp.AlbumTH;
                        $scope.AlbumCk = resp.AlbumCk;
                        $scope.Artile = resp.Artile;
                        $scope.AlbumKt = resp.AlbumKt;
                        $scope.Handbook = resp.Handbook;
                        $scope.AlbumCntt = resp.AlbumCntt;
                    }
                });
            }
        });
    };
});