<%--
  Created by IntelliJ IDEA.
  User: 李箎
  Date: 2019/8/18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=gbk" language="java" pageEncoding="gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>2019/08/18</title>

</head>
<body>
<form action="Collectiont.action" method="post">
    集合类型的参数绑定<br/>
    公司名称：<input type="text" name="CompanyName"/><br/>
    担任职位：<input type="text" name="position"/><br/>
    入职时间：<input type="text" placeholder="示例：2008-05-24" name="beginDate"/><br/>
    入职时长：<input type="text" name="month"/><br/>

    从后端读到的数据：<br/>

    <%--items中不能有空格--%>
    <c:forEach items="${ALLNUSER}" var="nu" varStatus="status">
        <%--这样写，data从ui到db，集合也能传过去，vo对象映射接收ui数据，vo对象有集合类型的成员变量
        适合集合的批量修改--%>
        <input type="text" name="nUsers[${status.index}].nickname"  value="${nu.nickname}"><br/>
    </c:forEach>
    <input type="submit" value="集合绑定参数">
</form>
</body>
</html>
