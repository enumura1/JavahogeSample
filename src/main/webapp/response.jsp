<%@page contentType="text/html;charset=utf-8" %>
<!-- beanパッケージに含まれてるHogeBean、HogeDTOの情報を読み込み -->
<%@page import="bean.*" %>
<!-- リクエストスコープに格納したsdtoを使用する事を明記 -->
<jsp:useBean id ="sdto" scope="request" class="bean.HogeDTO" />
<html>
  <head>
    <title>表示画面</title>
  </head>
<body>
<h2>テーブルから取ってきた情報は以下の通り↓</h2>
<table border="0">
  <tr>
    <th width="50">番号</th>
    <th width="50">名前</th>
    <th width="50">点数</th>
  </tr>
<!-- DTOのリストから要素（bean）を取り出し -->
<%
  for(int i = 0; i < sdto.size(); i++){
    HogeBean sb = sdto.get(i);
%>
  <tr>
    <td align="center"><%= sb.getNo() %></td>
    <td align="center"><%= sb.getName() %></td>
    <td align="center"><%= sb.getScore() %></td>
  </tr>
<% } %>
</table>
</body>
</html>