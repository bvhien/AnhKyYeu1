app.controller('Ctrl', function ($scope) {
    $(document).ready(function () {
        $scope.LayThongTin();
        $("#User-dialog-save").dialog({
            autoOpen: false,
            resizable: false,
            height: 350,
            width: 450,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#User-dialog-save").dialog("close");
                    $scope.LayThongTin();
                }
            }
        });
        $("#User-dialog-thongbao").dialog({
            autoOpen: false,
            resizable: false,
            height: 250,
            width: 350,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#User-dialog-thongbao").dialog("close");
                }
            }
        });
        $("#Them-User").dialog({
            autoOpen: false,
            resizable: false,
            height: 500,
            width: 600,
            modal: true,
//            buttons: {
//                "Hủy": function () {
//                    $("#Them-User").dialog("close");
//                }
//            }
        });
        $("#Sua-User").dialog({
            autoOpen: false,
            resizable: false,
            height: 500,
            width: 600,
            modal: true
        });

        $("#Doi_MK").dialog({
            autoOpen: false,
            resizable: false,
            height: 500,
            width: 600,
            modal: true
        });
    });
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    $scope.validate = function () {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.Add.$valid)
        {
            $("#UserName").blur();
        }
        return $scope.myForm.Add.$valid;
    };
    $scope.validateEdit = function () {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.Edit.$valid)
        {
            $("#UserName").blur();
        }
        return $scope.myForm.Edit.$valid;
    };
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../User",
            type: 'GET',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                $scope.$apply(function () {
                    console.log(resp);
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.TableUser = resp.TableUser;
                        $scope.TrangThai = resp.TrangThai;
                        $scope.Permiss = resp.Permiss;
                    }
                });
            }
        });
    };

    $scope.ShowPopupThem = function () {
        $scope.User='';
        $("#Them-User").dialog("open");
    };

    $scope.ClosePopupThem = function () {
        $("#Them-User").dialog("close");
        $scope.User = '';
    };
    $scope.ThemUser = function () {
        console.log($scope.User);
        var check = $scope.validate();
        if (check) {
            $.ajax({
                url: "../../User",
                type: 'GET',
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: {
                    type: "LuuThongTin",
                    data: (encodeURIComponent(JSON.stringify($scope.User))),
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            $("#Them-User").dialog("close");
                            $scope.User = '';
                            $("#User-dialog-save").text("Lưu thành công");
                            $("#User-dialog-save").dialog("open");
                        }
                    });
                }
            });
        }
    };

    $scope.Xoa = function () {
        $scope.XoaUser = [];
        for (var i = 0; i < $scope.TableUser.length; i++) {
            if ($scope.TableUser[i].Checked == 1) {
                $scope.XoaUser.push($scope.TableUser[i]);
            }
        }
        if ($scope.XoaUser.length == 0) {
            $("#User-dialog-save").text("Bạn cần chọn bản ghi để xóa");
            $("#User-dialog-save").dialog("open");
        } else {
            $("#User-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        $.ajax({
                            url: "../../User",
                            type: 'GET',
                            contentType: "application/json; charset=utf-8",
                            dataType: 'json',
                            data: {
                                type: "XoaUser",
                                data: (encodeURIComponent(JSON.stringify($scope.XoaUser))),
                            },
                            success: function (resp) {
                                $scope.$apply(function () {
                                    if (resp.errorCode == 'SUCCESS') {
                                        $scope.LayThongTin();
                                        $("#User-dialog-thongbao").dialog("close");
                                        $("#User-dialog-save").text("Xóa thành công");
                                        $("#User-dialog-save").dialog("open");
                                    }
                                });
                            }
                        });
                    },
                    "Không": function () {
                        $("#User-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#User-dialog-thongbao").text("Bạn có chắc chắn muốn xóa bản ghi đã chọn !");
            $("#User-dialog-thongbao").dialog("open");
        }

    };

    $scope.ShowPopupSua = function (Id) {
        $.ajax({
            url: "../../User",
            type: 'GET',
            data: {
                type: "ShowPopupSua",
                data: Id
            },
            success: function (resp) {
                $scope.$apply(function () {
                    console.log(resp);
                    if (resp.errorCode == 'SUCCESS') {
                        $("#Sua-User").dialog("open");
                        $scope.ChangeUser = resp.ChangeUser[0];
                        $scope.ChangeUser.UserPermission = String(resp.ChangeUser[0].UserPermission);
                    }
                });
            }
        });
    };

    $scope.ClosePopupSua = function () {
        $("#Sua-User").dialog("close");
        $scope.ChangeUser = '';
    };

    $scope.SuaUser = function () {
        if ($scope.ChangeUser != null && $scope.ChangeUser != undefined && $scope.ChangeUser != '') {
            var check = $scope.validateEdit();
            if (check) {
                $.ajax({
                    url: "../../User",
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    data: {
                        type: "SuaUser",
                        data: (encodeURIComponent(JSON.stringify($scope.ChangeUser))),
                    },
                    success: function (resp) {
                        $scope.$apply(function () {
                            if (resp.errorCode == 'SUCCESS') {
                                $("#Sua-User").dialog("close");
                                $("#User-dialog-save").text("Lưu thành công");
                                $("#User-dialog-save").dialog("open");
                            }
                        });
                    }
                });
            }
        }
    };
});