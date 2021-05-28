<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジューラー</title>
</head>
<body>
	<div align="center">
		<h1>スケジューラー</h1>
		<%
		if (loginUser != null) {
		%>
		<p>ログインに成功しました</p>
		<p>
			ようこそ<%=loginUser.getName()%>さん
		</p>
		<a href="/schedule/Calender">メイン画面へ</a>
		<%
		} else {
		%>
		<p>ログインに失敗しました</p>
		<a href="/schedule/">トップへ</a>
		<%
		}
		%>

		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>