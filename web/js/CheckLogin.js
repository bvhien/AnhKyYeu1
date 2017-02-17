function DangXuat() {
    console.log("Vao");
    $.ajax({
        url: "../../Login",
        type: 'POST',
        data: {type: "DangXuat",
        },
        success: function (resp) {
            if (resp.errorCode == 'ERRORLOGIN') {
                location.href = resp.Url;
            }
        }
    });
}

function List () {
    $.ajax({
        url: "../../Login",
        type: 'POST',
        data: {
            type: "CheckLogin",
        },
        success: function (resp) {
            console.log(resp);
            if (resp.errorCode == 'ERRORLOGIN') {
                location.href = resp.Url;
            } else if (resp.errorCode == 'SUCCESS') {
                console.log("thanh cong:" + resp.InfoLogin[0].UserFullName);
                document.getElementById('ThongTinTK').innerHTML = resp.InfoLogin[0].UserFullName;
            }
        }
    });
};
