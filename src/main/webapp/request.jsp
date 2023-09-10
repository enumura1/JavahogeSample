<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- クライアントからサーバーにデータを送信する -->
<form method='post' action='HelloServlet'>
    <!-- textNameという名前でテキストをサーバーに送る -->
    <input type="text" name="textName">
    <!-- サーバーにデータを送るためのボタン -->
    <input type="submit" value="送信">
</form>

<body>

</body>
</html>