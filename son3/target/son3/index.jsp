<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="gbk" />
</head>

<body>

<h1>springMVC 普通类型参数绑定</h1>
<c:forEach items="${list}" var="str">
    ${str}<br/>
</c:forEach>
${messi}
<form action="cdt.action" method="post">
    普通类型参数绑定示例<br/>
    <input type="text" placeholder="姓名" name="name"><br/>
    <input type="text" placeholder="年龄" name="age"><br/>
    <input type="text" placeholder="性别（输入男或女）" name="SEX"><br/>
    <input type="submit" value="提交"><br/>
</form>
</body>

</html>
