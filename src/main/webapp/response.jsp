<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
// サーブレットから送られてきたテキストを受け取る
String afterText = (String)request.getAttribute("responseText");
%>

<body>
<%=afterText %>
</body>
</html>