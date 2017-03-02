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
    });
    $scope.sort = function (keyname) {
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    $scope.validate = function () {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.$valid)
        {
            $("#UserName").blur();
        }
        return $scope.myForm.$valid;
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
});