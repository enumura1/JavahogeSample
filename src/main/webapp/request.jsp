<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>リクエストjsp</h1>
<!-- クライアントからサーバーにデータを送信する -->
<form method='post' action='HelloServlet'>
    <!-- textNameという名前でテキストをサーバーに送る -->
    <p>以下の「表示ボタン」を押下すると、テーブルのデータを表示します。</p>
    <!-- サーバーにデータを送るためのボタン -->
    <input type="submit" value="表示">
</form>

</body>
</html>