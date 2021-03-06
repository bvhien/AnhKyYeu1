app.controller('Ctrl', function ($scope) {
    $(document).ready(function () {
        $scope.LayThongTin();
        $("#Image-dialog-save").dialog({
            autoOpen: false,
            resizable: false,
            height: 350,
            width: 450,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Image-dialog-save").dialog("close");
                    $scope.LayDSAnh($scope.Image.AlbumId);
                }
            }
        });
        $("#Image-dialog-thongbao").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Image-dialog-thongbao").dialog("close");
                }
            }
        });
    });
    $scope.stepsModel = [];
    $scope.imageChoose = function (event) {
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
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Image",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.Category = resp.Category;
                        if ($scope.Image == null && $scope.Image == undefined) {
                            $scope.Image = {
                                CategoryId: 1
                            };
                        }
                         $scope.LayDSAlbum($scope.Image.CategoryId);
                    }
                });
            }
        });
    };
    $scope.LayDSAlbum = function (CategoryId) {
        $.ajax({
            url: "../../Image",
            type: 'GET',
            data: {
                type: "LayDSAlbum",
                data: CategoryId
            },
            success: function (resp) {
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.Album = resp.Album;
                        if ($scope.Album != null && $scope.Album != undefined) {
                            $scope.Image.AlbumId = $scope.Album[0].AlbumId;
                            $scope.LayDSAnh($scope.Image.AlbumId);
                        }
                    }
                });
            }
        });
    };
    //-------Them anh vao Album--------

    $scope.ThemImage = function (CategoryId, AlbumId) {
        if ($scope.stepsModel.length == 0) {
            $("#Image-dialog-thongbao").text("Vui lòng chọn ảnh!");
            $("#Image-dialog-thongbao").dialog("open");
        } else {
            $.ajax({
                url: "../../Image",
                type: 'POST',
                data: {
                    type: "LuuAnh",
                    CategoryId: CategoryId,
                    AlbumId: AlbumId,
                    data: encodeURIComponent(JSON.stringify($scope.stepsModel))
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            $scope.stepsModel = [];
                            $scope.LayDSAnh(AlbumId);
                            $("#Image-dialog-save").dialog("open");
                        }
                    });
                }
            });
        }
    };
    //Lay Album Anh
    $scope.LayDSAnh = function (AlbumId) {
        $.ajax({
            url: "../../Image",
            type: 'GET',
            data: {
                type: "LayDSImage",
                data: AlbumId
            },
            success: function (resp) {
                $scope.$apply(function () {
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.AlbumImage = resp.AlbumImage;
                    }
                });
            }
        });
    };
    //-----------Xóa ảnh trong Album

    $scope.DeleteImage = function (imageId, imageUrl) {
        $("#Image-dialog-thongbao").dialog({
            buttons: {
                "Có": function () {
                    $.ajax({
                        url: "../../Image",
                        type: 'GET',
                        data: {
                            type: "DeleteImage",
                            imageId: imageId,
                            imageUrl: imageUrl
                        },
                        success: function (resp) {
                            $scope.$apply(function () {
                                if (resp.errorCode == 'SUCCESS') {
                                    $("#Image-dialog-thongbao").dialog("close");
                                    $("#Image-dialog-save").text("Xóa thành công");
                                    $("#Image-dialog-save").dialog("open");
                                }
                            });
                        }
                    });
                },
                "Không": function () {
                    $("#Image-dialog-thongbao").dialog("close");
                }
            }
        });
        $("#Image-dialog-thongbao").text("Bạn có chắc chắn muốn xóa bản ghi đã chọn !");
        $("#Image-dialog-thongbao").dialog("open");
    }
});