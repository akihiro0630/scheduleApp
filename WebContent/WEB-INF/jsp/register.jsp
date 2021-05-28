<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% String errorMsg = (String)session.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
</head>
<body>

	<div align="center">
		<h1>スケジューラー</h1>
		<h2>新規登録</h2>
		<h2> <font color="red">${errorMsg}</font></h2>
		<form action="/schedule/Register" method="post">
			<table border=1>
				<tr>
					<th>メールアドレス（ユーザーID）</th>
					<td><input type="text" name="registerID" size="50"></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name="registerPass" size="50"></td>
				</tr>
				<tr>
					<th>氏名</th>
					<td><input type="text" name="registerName" size="50"></td>
				</tr>
			</table><br>
			<input type="submit" value="登録">
			<input type="button" value="戻る" onclick="history.back()">
		</form>
	</div>
</body>
</html>