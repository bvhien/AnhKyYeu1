app.controller('Ctrl', function ($scope) {
    $(document).ready(function () {
        $scope.isEdit = false;
        $scope.LayThongTin();
        $("#Thamso-dialog-save").dialog({
            autoOpen: false,
            resizable: false,
            height: 350,
            width: 450,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Thamso-dialog-save").dialog("close");
                    $scope.LayThongTin();
                }
            }
        });
        $("#Thamso-dialog-thongbao").dialog({
            autoOpen: false,
            resizable: false,
            height: 350,
            width: 450,
            modal: true,
            buttons: {
                "Đóng": function () {
                    $("#Thamso-dialog-thongbao").dialog("close");
                }
            }
        });
    });
    $scope.LayThongTin = function () {
        $.ajax({
            url: "../../Thamso",
            type: 'POST',
            data: {
                type: "LayThongTin",
            },
            success: function (resp) {
                $scope.$apply(function () {
                    console.log(resp);
                    if (resp.errorCode == 'SUCCESS') {
                        $scope.TableThamSo = resp.ThamSo;
                    }
                });
            }
        });
    };
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    $scope.ThemThamSo = function () {
        var check = $scope.validate();
        console.log((JSON.stringify($scope.ThamSo)));
        console.log(encodeURIComponent(JSON.stringify($scope.ThamSo)));
        if (check) {
            $.ajax({
                url: "../../Thamso",
                type: 'GET',
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                data: {
                    type: "LuuThongTin",
                    data: (encodeURIComponent(JSON.stringify($scope.ThamSo))),
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            $scope.ThamSo = null;
                            $("#Thamso-dialog-save").text("Lưu thành công");
                            $("#Thamso-dialog-save").dialog("open");
                        }
                    });
                }
            });
        }
    };
    $scope.SuaBanGhi = function (index) {
        if (index !== null) {
            $scope.isEdit = true;
            $scope.ThamSo = $scope.TableThamSo[index];

        }
    };

    $scope.CapNhatThamSo = function () {
        if ($scope.ThamSo != null && $scope.ThamSo != undefined && $scope.ThamSo != '') {
            var check = $scope.validate();
            console.log(JSON.stringify($scope.ThamSo));
            if (check) {
                $.ajax({
                    url: "../../Thamso",
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    data: {
                        type: "CapNhat",
                        data: (encodeURIComponent(JSON.stringify($scope.ThamSo))),
                    },
                    success: function (resp) {
                        $scope.$apply(function () {
                            if (resp.errorCode == 'SUCCESS') {
                                $scope.ThamSo = null;
                                $scope.isEdit = false;
                                $("#Thamso-dialog-save").text("Cập nhật thành công");
                                $("#Thamso-dialog-save").dialog("open");
                            }
                        });
                    }
                });
            }
        }
    };
    $scope.Huy = function () {
        $scope.isEdit = false;
        $scope.ThamSo = null;
    };
    $scope.XoaNhieuBanGhi = function () {
        $scope.XoaCSDLThamSo = [];
        for (var i = 0; i < $scope.TableThamSo.length; i++) {
            if ($scope.TableThamSo[i].Checked == 1) {
                $scope.XoaCSDLThamSo.push($scope.TableThamSo[i]);
            }
        }
        if ($scope.XoaCSDLThamSo != null && $scope.XoaCSDLThamSo != undefined && $scope.XoaCSDLThamSo != '') {
            $("#Thamso-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        $.ajax({
                            url: "../../Thamso",
                            type: 'GET',
                            contentType: 'application/json; charset=utf-8',
                            data: {
                                type: "XoaNhieuThamSo",
                                data: encodeURIComponent(JSON.stringify($scope.XoaCSDLThamSo))
                            },
                            success: function (resp) {
                                $scope.$apply(function () {
                                    if (resp.errorCode === 'SUCCESS') {
                                        $scope.LayThongTin();
                                        $("#Thamso-dialog-thongbao").dialog("close");
                                        $("#Thamso-dialog-save").text("Xóa thành công");
                                        $("#Thamso-dialog-save").dialog("open");
                                    }
                                });
                            }
                        });
                    },
                    "Không": function () {
                        $("#Thamso-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#Thamso-dialog-thongbao").text("Bạn có chắc chắn muốn xóa bản ghi đã chọn !");
            $("#Thamso-dialog-thongbao").dialog("open");
        } else {
            $("#Thamso-dialog-thongbao").text("Bạn chưa chọn bản ghi nào để xóa !");
            $("#Thamso-dialog-thongbao").dialog("open");
        }
    };
    $scope.XoaBanGhi = function (index) {
        if (index !== null) {
            $("#Thamso-dialog-thongbao").dialog({
                buttons: {
                    "Có": function () {
                        $scope.XoaCSDLThamSo = $scope.TableThamSo[index];
                        $.ajax({
                            url: "../../Thamso",
                            type: 'POST',
                            data: {
                                type: "XoaBanGhi",
                                data: encodeURIComponent(JSON.stringify($scope.XoaCSDLThamSo))
                            },
                            success: function (resp) {
                                $scope.$apply(function () {
                                    if (resp.errorCode === 'SUCCESS') {
                                        $scope.TableThamSo.splice(index, 1);
                                        $("#Thamso-dialog-save").text("Xóa thành công");
                                        $("#Thamso-dialog-thongbao").dialog("close");
                                        $("#Thamso-dialog-save").dialog("open");
                                    }
                                });
                            }
                        });
                    },
                    "Không": function () {
                        $("#Thamso-dialog-thongbao").dialog("close");
                    }
                }
            });
            $("#Thamso-dialog-thongbao").text("Bạn có chắc chắn muốn xóa !");
            $("#Thamso-dialog-thongbao").dialog("open");
        }

    };
    $scope.validate = function (){
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.$valid)
        {
            $("#TenThamSo").blur();
        }
        return $scope.myForm.$valid;
    };
});