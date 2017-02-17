var app = angular.module('app', ['ngRoute']);
app.controller('Login', function ($scope) {
    $(document).ready(function () {
        $scope.errorLogin = false;
        $(document).keypress(function (e) {
            if (e.which == 13) {
                $scope.CheckLogin();
            }
        });
    });
    $scope.CheckLogin = function () {
        var check = $scope.validate();
        if (check && $scope.Login != null && $scope.Login != undefined && $scope.Login != '') {
            $.ajax({
                url: "../../Login",
                type: 'POST',
                data: {
                    type: "CheckThongTin",
                    data: JSON.stringify($scope.Login)
                },
                success: function (resp) {
                    $scope.$apply(function () {
                        if (resp.errorCode == 'SUCCESS') {
                            location.href = "Thamso.jsp";
                        } else if (resp.errorCode == 'ERRORLOGIN') {
                            $scope.errorLogin = true;
                        }
                    });
                }
            });
        }
    };
    
    $scope.validate = function ()
    {
        $scope.$broadcast('checkRequired');
        if (!$scope.myForm.$valid)
        {
            $("#UserName").blur();
        }
        return $scope.myForm.$valid;
    };
});