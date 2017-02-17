app.controller('Ctrl', function ($scope) {
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    $(document).ready(function () {
        $scope.isEdit = false;
        $scope.LayThongTin();
        $("#Album-dialog-save").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Album-dialog-save").dialog("close");
                    $scope.LayThongTin();
                }
            }
        });

        $("#Album-dialog-thongbao").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Album-dialog-thongbao").dialog("close");
                }
            }
        });
    });
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
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Album",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                console.log(resp);
                $scope.$apply(function () {
                    $scope.DanhMuc = resp.Category;
                    $scope.TrangThai = resp.TrangThai;
                    $scope.TblAlbum = resp.TblAlbum;
                });
            }
        });
    };
    $scope.ThemAlbum = function () {
        var check = $scope.validate();
        if (check) {
            if ($scope.stepsModel != null && $scope.stepsModel != undefined && $scope.stepsModel != '') {
                if ($scope.Album != undefined) {
                    $scope.Album.AnhTieuDe = $scope.stepsModel[0];
                }
                $.ajax({
                    url: "../../Album",
                    type: 'POST',
                    data: {
                        type: "LuuThongTin",
                        data: encodeURIComponent(JSON.stringify($scope.Album)),
                    },
                    success: function (resp) {
                        $scope.$apply(function () {
                            if (resp.errorCode == 'SUCCESS') {
                                $("#Album-dialog-save").text("Lưu thành công");
                                $("#Album-dialog-save").dialog("open");
                            }
                        });
                    }
                });
            }
        }
    };

    var RowId;
    $scope.SuaBanGhi = function (Id) {
        if (Id != null && Id != undefined) {
            for (var i = 0; i < $scope.TblAlbum.length; i++) {
                if ($scope.TblAlbum[i].Id == Id) {
                    $scope.Album = $scope.TblAlbum[i];
                    $scope.stepsModel = [];
                    $scope.stepsModel.push("../../Guest-Image/" + $scope.TblAlbum[i].AnhTieuDe.toString());
                    RowId = i;
                }
            }
            $scope.isEdit = true;
        }
    };

    $scope.CapNhat = function () {
        if ($scope.stepsModel != null && $scope.stepsModel != undefined && $scope.stepsModel != '') {
            var check = $scope.validate();
            if ($scope.Album != undefined) {
                if ($scope.stepsModel[0] != $scope.TblAlbum[RowId]) {
                    $scope.Album.AnhTieuDeMoi = $scope.stepsModel[0];
                }
            }
            if (check) {
                $.ajax({
                    url: "../../Album",
                    type: 'POST',
                    data: {
                        type: "CapNhat",
                        data: encodeURIComponent(JSON.stringify($scope.Album)),
                    },
                    success: function (resp) {
                        $scope.$apply(function () {
                            if (resp.errorCode == 'SUCCESS') {
                                $("#Album-dialog-save").text("Cập nhật thành công");
                                $("#Album-dialog-save").dialog("open");
                            }
                        });
                    }
                });
            }
        }
    };

    $scope.Huy = function () {
        $scope.isEdit = false;
        $scope.Album = null;
    };

    $scope.XoaBanGhi = function (Id) {
        if (Id != null && Id != undefined) {
            $("#Album-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        for (var i = 0; i < $scope.TblAlbum.length; i++) {
                            if ($scope.TblAlbum[i].Id == Id) {
                                $scope.XoaALbum = $scope.TblAlbum[i];
                                $.ajax({
                                    url: "../../Album",
                                    type: 'POST',
                                    data: {
                                        type: "XoaBanGhi",
                                        data: encodeURIComponent(JSON.stringify($scope.XoaALbum))
                                    },
                                    success: function (resp) {
                                        $scope.$apply(function () {
                                            if (resp.errorCode === 'SUCCESS') {
                                                $scope.TblAlbum.splice(i, 1);
                                                $("#Album-dialog-save").text("Xóa thành công");
                                                $("#Album-dialog-thongbao").dialog("close");
                                                $("#Album-dialog-save").dialog("open");
                                            }
                                        });
                                    }
                                });
                            }
                        }
                    },
                    "Không": function () {
                        $("#Album-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#Album-dialog-thongbao").text("Bạn có chắc chắn muốn xóa !");
            $("#Album-dialog-thongbao").dialog("open");
        }
    };


    $scope.XoaNhieuBanGhi = function () {
        $scope.XoaCSDLAlbum = [];
        for (var i = 0; i < $scope.TblAlbum.length; i++) {
            if ($scope.TblAlbum[i].Checked == 1) {
                $scope.XoaCSDLAlbum.push($scope.TblAlbum[i]);
            }
        }
        if ($scope.XoaCSDLAlbum != null && $scope.XoaCSDLAlbum != undefined && $scope.XoaCSDLAlbum != '') {
            $("#Album-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        $.ajax({
                            url: "../../Album",
                            type: 'GET',
                            contentType: 'application/json; charset=utf-8',
                            data: {
                                type: "XoaNhieuAlbum",
                                data: encodeURIComponent(JSON.stringify($scope.XoaCSDLAlbum))
                            },
                            success: function (resp) {
                                $scope.$apply(function () {
                                    if (resp.errorCode === 'SUCCESS') {
                                        $scope.LayThongTin();
                                        $("#Album-dialog-thongbao").dialog("close");
                                        $("#Album-dialog-save").text("Xóa thành công");
                                        $("#Album-dialog-save").dialog("open");
                                    }
                                });
                            }
                        });
                    },
                    "Không": function () {
                        $("#Album-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#Album-dialog-thongbao").text("Bạn có chắc chắn muốn xóa bản ghi đã chọn !");
            $("#Album-dialog-thongbao").dialog("open");
        } else {
            $("#Album-dialog-thongbao").text("Bạn chưa chọn bản ghi nào để xóa !");
            $("#Album-dialog-thongbao").dialog("open");
        }
    };

    $scope.validate = function () {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.$valid)
        {
            $("#TieuDe").blur();
        }
        return $scope.myForm.$valid;
    };
});