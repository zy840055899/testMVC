<%--
  Created by IntelliJ IDEA.
  User: zhengying
  Date: 2017/5/2
  Time: 下午2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/login.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a id="modal-95453" href="#modal-container-95453" role="button" class="btn" data-toggle="modal" style="display: none">触发遮罩窗体</a>

            <div class="modal fade" id="modal-container-95453" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                提示
                            </h4>
                        </div>
                        <div class="modal-body">
                            内容...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <%--<button type="button" class="btn btn-primary">保存</button>--%>
                        </div>
                    </div>
                </div>
            </div>

            <div class="tabbable" id="tabs-921296">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <!--<a href="#panel-632834" data-toggle="tab">登录</a>-->
                        <a href="#form1" data-toggle="tab">登录</a>
                    </li>
                    <li>
                        <!--<a href="#panel-310436" data-toggle="tab">注册</a>-->
                        <a href="#form2" data-toggle="tab">注册</a>
                    </li>
                </ul>
            </div>

            <div class="tab-content" style="margin-top: 2%;">
                <form class="form-horizontal tab-pane active" role="form" id="form1">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword3" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" />记住我</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default">登录</button>
                        </div>
                    </div>
                </form>
                <%------------注册-----------%>
                <form class="form-horizontal tab-pane" role="form" id="form2">
                    <div class="form-group">
                        <label for="inputEmail33" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail33"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword33" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword33"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword44" class="col-sm-2 control-label">重复密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword44" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default">注册</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


</body>
</html>
