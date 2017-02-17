var AddImage;
app.controller('AddImage', function ($scope) {
    $scope.stepsModel = [];

    $scope.imageUpload = function (event) {
        var files = event.target.files; //FileList object
        $scope.Imagedata = files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var reader = new FileReader();
            reader.onload = $scope.imageIsLoaded;
            reader.readAsDataURL(file);
        }
    }

    $scope.imageIsLoaded = function (e) {
        $scope.$apply(function () {
            $scope.stepsModel.push(e.target.result);
        });
    }
    $scope.Upload = function () {
        $.ajax({
            url: "../UploadImage",
            
            type:'POST',
            data: {
                data: $scope.stepsModel,
            },
            success: function (resp) {
                $scope.$apply(function () {
                    console.log("secsess");
                });
            }
        });
    }
});
app.directive('fileReader', function () {
    return {
        scope: {
            fileReader: "="
        },
        link: function (scope, element) {
            $(element).on('change', function (changeEvent) {
                var files = changeEvent.target.files;
                AddImage = files;
                scope.fileReader = [];
                if (files.length) {
                    var r = new FileReader();
                    r.onload = function (e) {
                        var contents = e.target.result;
                        scope.$apply(function () {
                            scope.fileReader = contents;
                        });
                    };

                    r.readAsDataURL(files[0]);
                }
            });
        }
    };
});
