<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean result = (boolean) request.getAttribute("result");
String ymd = (String) request.getAttribute("ymd");
String resultj;
if (result == true) {
	resultj = "更新が完了しました";
} else {
	resultj = "更新が失敗しました";
}
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
		<p><%=resultj%></p>
		<form action="/schedule/ScheduleAccsess" method="post">
			<input type="hidden" name="ymd" value=<%=ymd%>>
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>