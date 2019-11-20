<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="gbk" %>
<html>
<head>
    <title>springMVC - NUser</title>
</head>
<body>
    <form action="pojodt.action" method="post">
        pojo类型的参数绑定示例；校验器示例；数据回显示例<br/>
        uID：<input type="text" name="uID"><br/>
        nickname：<input type="text" name="nickname" value="${nickname}">${nicknameErr}<br/>
        password：<input type="text" name="password" value="${password}"><br/>
        <input type="submit" value="提交"><br/>
    </form>
    <hr/>

    <form action="custom.action" method="post">
        自定义方法参数<br/>
        公司名称：<input type="text" name="CompanyName"/><br/>
        担任职位：<input type="text" name="position"/><br/>
        入职时间：<input type="text" placeholder="示例：2008-05-24" name="beginDate"/><br/>
        入职时长：<input type="text" name="month"/><br/>
        <input type="submit" value="提交"/><br/>
    </form>
    <hr/>

    <form action="Arrayt.action" method="post">
        数组类型的参数绑定<br/>
        <input type="checkbox" name="hobby" value="a">A<br/>
        <input type="checkbox" name="hobby" value="b">B<br/>
        <input type="checkbox" name="hobby" value="c">C<br/>
        <input type="checkbox" name="hobby" value="d">D<br/>
        <input type="checkbox" name="hobby" value="e">E<br/>
        <input type="checkbox" name="hobby" value="f">F<br/>
        <input type="checkbox" name="hobby" value="g">G<br/>
        <input type="submit" value="提交Array">
    </form>

    <hr/>

    <form action="upload.action" method="post" enctype="multipart/form-data">
        <input type="file" name="pic">
        <input type="text" name="title">
        <input type="submit" value="上传">

    </form>
</body>
</html>
