app.controller('Index', function ($scope) {
    $(document).ready(function () {
        $scope.LayThongTin();
    });
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Index",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
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
app.directive('slider', ['$timeout', function ($timeout) {
        return {
            restrict: 'A',
            link: function (scope, elem, attrs) {
                // timeout internals are called once directive rendering is complete
                $timeout(function () {
                    setTimeout(function () {
                        $("#slider1").responsiveSlides({
                            maxwidth: 1170,
                            speed: 800
                        });
                    });
                });
            }
        };
    }]);