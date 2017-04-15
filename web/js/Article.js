app.controller('Ctrl', function ($scope) {
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    $(document).ready(function () {
        $scope.LayThongTin();
        $scope.isShowDetail = false;
        $("#Article-dialog-save").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Article-dialog-save").dialog("close");
                    $scope.LayThongTin();
                }
            }
        });
        $("#Article-dialog-thongbao").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Article-dialog-thongbao").dialog("close");
                }
            }
        });
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
                    $scope.TrangThai = resp.TrangThai;
                    $scope.section = resp.section;
                    $scope.TblArticle = resp.Article;
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

    $scope.ThemArticle = function () {
        var check = $scope.validate();
        if (check) {
            $scope.Article.Image = $scope.stepsModel[0];
            $scope.Article.Content = $("#txtEditor").Editor("getText");
            $.ajax({
                url: "../../Article",
                type: 'POST',
                data: {
                    type: "LuuThongTin",
                    data: encodeURIComponent(JSON.stringify($scope.Article))
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            $("#Article-dialog-save").dialog({
                                autoOpen: false,
                                resizable: false,
                                height: 250,
                                width: 350,
                                modal: true,
                                buttons: {
                                    "Đóng": function () {
                                        $("#Article-dialog-save").dialog("close");
                                        $scope.Article = undefined;
                                        $scope.isShowDetail = false;
                                        $scope.LayThongTin();
                                    }
                                }
                            });
                            $("#Article-dialog-save").text("Lưu thành công");
                            $("#Article-dialog-save").dialog("open");
                        }
                    });
                }
            });
        }
    };

    var RowId;
    $scope.SuaBanGhi = function (Id) {
        $scope.isEdit = true;
        if (Id) {
            for (var i = 0; i < $scope.TblArticle.length; i++) {
                if ($scope.TblArticle[i].articleId == Id) {
                    $scope.Article = $scope.TblArticle[i];
                    $scope.stepsModel = [];
                    $scope.stepsModel.push("../../Guest-Image/" + $scope.TblArticle[i].Image.toString());
                    $("#txtEditor").Editor("setText", $scope.TblArticle[i].Content)
                    RowId = i;
                    $scope.isShowDetail = true;
                }
            }
        }
    };

    $scope.SuaArticle = function () {
        var check = $scope.validate();
        if (check) {
//            $scope.Article.Image = $scope.stepsModel[0];
            $scope.Article.Content = $("#txtEditor").Editor("getText");
            if ($scope.Article != undefined) {
                if ($scope.stepsModel[0].replace("../../Guest-Image/", "") != $scope.Article.Image) {
                    $scope.Article.AnhTieuDeMoi = $scope.stepsModel[0];
                }
            }
            $.ajax({
                url: "../../Article",
                type: 'POST',
                data: {
                    type: "SuaArticle",
                    data: encodeURIComponent(JSON.stringify($scope.Article)),
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            $("#Article-dialog-save").dialog({
                                autoOpen: false,
                                resizable: false,
                                height: 250,
                                width: 350,
                                modal: true,
                                buttons: {
                                    "Đóng": function () {
                                        $("#Article-dialog-save").dialog("close");
                                        $scope.Article = undefined;
                                        $scope.isShowDetail = false;
                                        $scope.LayThongTin();
                                    }
                                }
                            });
                            $("#Article-dialog-save").text("Lưu thành công");
                            $("#Article-dialog-save").dialog("open");
                        }
                    });
                }
            });
        }
    };

    $scope.XoaArticle = function () {
        $scope.Xoa = [];
        for (var i = 0; i < $scope.TblArticle.length; i++) {
            if ($scope.TblArticle[i].Checked == 1) {
                $scope.Xoa.push($scope.TblArticle[i]);
            }
        }
        if ($scope.Xoa != null && $scope.Xoa != undefined && $scope.Xoa != '') {
            $("#Article-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        $.ajax({
                            url: "../../Article",
                            type: 'POST',
                            data: {
                                type: "XoaArticle",
                                data: encodeURIComponent(JSON.stringify($scope.Xoa))
                            },
                            success: function (resp) {
                                $scope.$apply(function () {
                                    if (resp.errorCode === 'SUCCESS') {
                                        $scope.LayThongTin();
                                        $("#Article-dialog-thongbao").dialog("close");
                                        $("#Article-dialog-save").text("Xóa thành công");
                                        $("#Article-dialog-save").dialog("open");
                                    }
                                });
                            }
                        });
                    },
                    "Không": function () {
                        $("#Article-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#Article-dialog-thongbao").text("Bạn có chắc chắn muốn xóa bản ghi đã chọn !");
            $("#Article-dialog-thongbao").dialog("open");
        } else {
            $("#Article-dialog-thongbao").text("Bạn chưa chọn bản ghi nào để xóa !");
            $("#Article-dialog-thongbao").dialog("open");
        }
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