<%--
  Created by IntelliJ IDEA.
  User: ��}
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
    �������͵Ĳ�����<br/>
    ��˾���ƣ�<input type="text" name="CompanyName"/><br/>
    ����ְλ��<input type="text" name="position"/><br/>
    ��ְʱ�䣺<input type="text" placeholder="ʾ����2008-05-24" name="beginDate"/><br/>
    ��ְʱ����<input type="text" name="month"/><br/>

    �Ӻ�˶��������ݣ�<br/>

    <%--items�в����пո�--%>
    <c:forEach items="${ALLNUSER}" var="nu" varStatus="status">
        <%--����д��data��ui��db������Ҳ�ܴ���ȥ��vo����ӳ�����ui���ݣ�vo�����м������͵ĳ�Ա����
        �ʺϼ��ϵ������޸�--%>
        <input type="text" name="nUsers[${status.index}].nickname"  value="${nu.nickname}"><br/>
    </c:forEach>
    <input type="submit" value="���ϰ󶨲���">
</form>
</body>
</html>
