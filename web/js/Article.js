app.controller('Ctrl', function ($scope) {
    $(document).ready(function () {
        $scope.LayThongTin();
        $scope.isShowDetail = false;
//       $("#AddArticle").dialog({
//            autoOpen: false,
//            resizable: false,
//            height: 700,
//            width: 1200,
//            modal: true,
////            buttons: {
////                "Đóng": function () {
////                    $("#AddArticle").dialog("close");
////                }
////            }
//        }); 
    });

    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Article",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                });
            }
        });
    };

    $scope.stepsModel = [];
    $scope.imageChoose = function (event) {
        if ($scope.stepsModel.length > 0) {
            $scope.stepsModel = [];
        }
        var files = event.target.files; //FileList object
        $scope.Imagedata = files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var reader = new FileReader();
            reader.onload = $scope.imageIsLoaded;
            reader.readAsDataURL(file);
        }
    };
    $scope.imageIsLoaded = function (e) {
        $scope.$apply(function () {
            $scope.stepsModel.push(e.target.result);
        });
    };

    $scope.AddArticle = function () {
        $scope.isShowDetail = true;
    };

    $scope.Huy = function () {
        $scope.Article = undefined;
        $scope.isShowDetail = false;
    };

    $scope.validate = function () {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.$valid)
        {
            $("#Title").blur();
        }
        return $scope.myForm.$valid;
    };
});