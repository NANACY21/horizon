<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="gbk" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="gbk" />
</head>

<body>

<h1>springMVC ��ͨ���Ͳ�����</h1>
<c:forEach items="${list}" var="str">
    ${str}<br/>
</c:forEach>
${messi}
<form action="cdt.action" method="post">
    ��ͨ���Ͳ�����ʾ��<br/>
    <input type="text" placeholder="����" name="name"><br/>
    <input type="text" placeholder="����" name="age"><br/>
    <input type="text" placeholder="�Ա������л�Ů��" name="SEX"><br/>
    <input type="submit" value="�ύ"><br/>
</form>
</body>

</html>
