app.controller('Ctrl', function ($scope) {
    $scope.stepsModel = [];
    $scope.imageChoose = function (event) {
//        if ($scope.stepsModel.length > 0) {
//            $scope.stepsModel = [];
//        }
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

    $scope.ClearImage = function (Index) {
        if (Index != null && Index != undefined && ($scope.stepsModel.length > 0)) {
            $scope.stepsModel.splice(Index, 1)
        }
    };
});