/**
 * Created by zhengying on 2017/5/3.
 */
$(function () {

   $alertBody = $("#modal-container-95453 .modal-body").eq(0);

   $("#addStaff").on('click', function () {
      $("tbody tr:last").show();
   });

   $("#addStaffBtn").on('click', function () {
       $.ajax({
           url: "addStaff",
           type: "post",
           data: $("#newStaffForm").serialize(),
           dataType: "json",
           success: function (data) {
               if(0 != data){
                   $alertBody.html("添加失败");
                   $("#modal-95453").click();
               }else{
                   $alertBody.html("添加成功");
                   $("#modal-95453").click();
                   // location.href="staffsInfo";					//登录成功，跳转至信息首页
               }
           },
           error: function () {
           }
       });
   });


   $(".updateStaff").on('click', function () {
       for(var i=0; i<6; i++){
           // $("#modal-container-954533 tbody tr").find("td").eq(i).html(
           //     $(this).closest("tr").find("td").eq(i).html()
           // );

           $("#modal-container-954533 tbody tr").find("td").eq(i).find("input").val (
               $(this).closest("tr").find("td").eq(i).html()
           );
       }
       $("#modal-954533").click();
   });

   $(".btn-primary").on('click', function () {
       $.ajax({
           url: "updateStaff",
           type: "post",
           data: $("#updateForm").serialize(),
           dataType: "json",
           success: function (data) {
               if(0 == data){
                   location.href = "staffsInfo?startPage="+$(".startPage").val();
               }else{
                   $alertBody.html("修改失败");
                   $("#modal-95453").click();
               }
           },
           error: function () {
           }
       });
   })



});