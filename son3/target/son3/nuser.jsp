<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="gbk" %>
<html>
<head>
    <title>springMVC - NUser</title>
</head>
<body>
    <form action="pojodt.action" method="post">
        pojo���͵Ĳ�����ʾ����У����ʾ�������ݻ���ʾ��<br/>
        uID��<input type="text" name="uID"><br/>
        nickname��<input type="text" name="nickname" value="${nickname}">${nicknameErr}<br/>
        password��<input type="text" name="password" value="${password}"><br/>
        <input type="submit" value="�ύ"><br/>
    </form>
    <hr/>

    <form action="custom.action" method="post">
        �Զ��巽������<br/>
        ��˾���ƣ�<input type="text" name="CompanyName"/><br/>
        ����ְλ��<input type="text" name="position"/><br/>
        ��ְʱ�䣺<input type="text" placeholder="ʾ����2008-05-24" name="beginDate"/><br/>
        ��ְʱ����<input type="text" name="month"/><br/>
        <input type="submit" value="�ύ"/><br/>
    </form>
    <hr/>

    <form action="Arrayt.action" method="post">
        �������͵Ĳ�����<br/>
        <input type="checkbox" name="hobby" value="a">A<br/>
        <input type="checkbox" name="hobby" value="b">B<br/>
        <input type="checkbox" name="hobby" value="c">C<br/>
        <input type="checkbox" name="hobby" value="d">D<br/>
        <input type="checkbox" name="hobby" value="e">E<br/>
        <input type="checkbox" name="hobby" value="f">F<br/>
        <input type="checkbox" name="hobby" value="g">G<br/>
        <input type="submit" value="�ύArray">
    </form>

    <hr/>

    <form action="upload.action" method="post" enctype="multipart/form-data">
        <input type="file" name="pic">
        <input type="text" name="title">
        <input type="submit" value="�ϴ�">

    </form>
</body>
</html>
