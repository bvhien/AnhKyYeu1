app.directive('valRequired', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {

            if (attrs.type === 'radio' || attrs.type === 'checkbox')
                return;
//			elm.unbind('input').unbind('keydown').unbind('change');
            elm.bind('blur', function () {
                safeApply(scope, checkRequired);
            });
            function safeApply(scope, fn) {
                (scope.$$phase || scope.$root.$$phase) ? fn() : scope.$apply(fn);
            }
            scope.$on('checkRequired', checkRequired);
            function checkRequired() {
                var check = false;
                if (elm.val() != null && elm.val() != undefined && elm.val() != "") {
                    var check = true;
                }
                ctrl.$setValidity('valRequired', check);
                return check;
            }
        }
    };
});

app.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {            	
//                if (text) {
                    var transformedInput = text.replace(/[^0-9]/g, '');                   
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);                    	 
                       ngModelCtrl.$render();
                    }

                   ngModelCtrl.$setValidity('numbersOnly', true);
                    return transformedInput;
//                }

//                return undefined;
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

