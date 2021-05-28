<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジューラー</title>
</head>
<body>
<div align="center">
<h1>スケジューラー</h1>
<h2>ログイン画面</h2>
<form action="/schedule/Login" method = "post">
ユーザーID：<input type ="text" name="id"><br>
パスワード：<input type ="password" name="pass"><br><br>

<input type ="submit" value="ログイン"><br></br>
<p>アカウント登録がお済でない方はこちら　<a href ="/schedule/Register" >新規登録</a></p>

</form>
</div>
</body>
</html>