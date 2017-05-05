/**
 * Created by zhengying on 2017/5/2.
 */

$(function () {

    $alertBody = $("#modal-container-95453 .modal-body").eq(0);

    //登录，用户名，密码
    $("#form1 .btn").on('click', function () {
        var params = {"username": $("#inputEmail3").val(), "password": $("#inputPassword3").val()};
        $.ajax({
            url: "checkLogin",
            type: "post",
            data: params,
            dataType: "json",
            success: function (data) {
                if(0 != data){
                    $alertBody.html("用户名或密码错误");
                    $("#modal-95453").click();
                }else{
                    location.href="staffsInfo";					//登录成功，跳转至信息首页
                }
            },
            error: function () {
            }
        });
    });


    //注册
    $("#form2 .btn").on('click', function () {
        var username = $("#inputEmail33").val().trim();
        var password = $("#inputPassword33").val().trim();
        var passwordR = $("#inputPassword44").val().trim();
        if(password != passwordR){
            $alertBody.html("密码不一致");
            $("#modal-95453").click();
            return;
        }
        if(username.length<1 || password.length<1){
            $alertBody.html("用户名或密码规则错误");
            $("#modal-95453").click();
            return;
        }
        var params = {"username": username, "password": password};
        $.ajax({
            url: "register",
            type: "post",
            data: params,
            dataType: "json",
            success: function (data) {
                console.log("zy::注册"+data);
                if(0 == data){
                    $alertBody.html("注册成功");
                    $("#modal-95453").click();
                } else if(1 == data){
                    $alertBody.html("用户名已存在");
                    $("#modal-95453").click();
                } else {
                    $alertBody.html("注册失败，请重试");
                    $("#modal-95453").click();
                }
            },
            error: function () {

            }
        });
    });





});

