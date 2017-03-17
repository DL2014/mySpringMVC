<%--
  Created by IntelliJ IDEA.
  User: dai
  Date: 2017/3/17
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
123123123

${oneuser.userName}

<br/>

<form action="/file/fileUpload" method="post" enctype="multipart/form-data">
    文件上传：
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
