<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%
	String ymd = (String)session.getAttribute("ymd");
	String year = ymd.substring(0,4);
	String month = ymd.substring(4,6);
	String date = ymd.substring(6,8);

	Integer sTime = Integer.parseInt((String)request.getAttribute("sTime"));
	String schedule = (String)request.getAttribute("schedule");

	User loginUser = (User)session.getAttribute("loginUser");
	String id = loginUser.getId();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール変更</title>
<style type="text/css">
.sample input[type="submit"]{
border:none;background:#FFF;text-decoration:underline;color:#00f;
}
.sample input:hover
{
cursor:pointer;
}
</style>
</head>
<body>
<div align="center">
<h1>スケジューラー</h1>
<h2><%=year %>年<%=month %>月<%=date %>日のスケジュール</h2>

<p><font size="5" color="#0000ff"><%=sTime %>:00~<%=sTime+1 %>:00</font></p>
<table>
	<tr>
		<td>変更前:</td>
		<td class="naiyou"><% if(schedule == null | schedule == "" ||schedule =="null"){%>

		<%} else {%>
			${schedule}
		<%}%>
		</td>
	</tr>
	<tr>
		<td>変更後:</td>
			<td class="naiyou">
				<form action="/schedule/ScheduleChange2" method="post">
					<input type="text" name="reSchedule">
					<input type="hidden" name="sTime" value=<%=sTime %>>
					<input type="hidden" name="ymd" value=<%=ymd %>>
					<input type="submit" value="更新">
				</form>
			</td>
	</tr>
</table>
<br>



		<form action="/schedule/ScheduleDelete" method="post">
				<input type="hidden" name="id" value= <%=id %>>
				<input type="hidden" name="ymd" value=<%=ymd %>>
				<input type="hidden" name="sTime" value=<%=sTime %>>
				<input type="submit" value="削除">
		</form>

<br>
		<form class="sample" action="/schedule/ScheduleAccsess" method="post">
			<input type="hidden" name="ymd" value=<%=ymd%>>
			<input type="submit" value="戻る">
		</form>



</div>

</body>
</html>