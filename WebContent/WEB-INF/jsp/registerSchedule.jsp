<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.DaySchedule" %>
<% String ymd = (String)session.getAttribute("ymd");
	String year = ymd.substring(0,4);
	String month = ymd.substring(4,6);
	String date = ymd.substring(6,8);

	DaySchedule daySchedule = (DaySchedule) request.getAttribute("daySchedule");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スケジュール入力</title>
	<style>
		td.jikan{width: 150px;text-align:center;}
		td.naiyou{width: 200px;text-align:center;}
		.ScheduleChange input[type="submit"]{
		border:none;background:#FFF;text-decoration:underline;color:#00f;
		}
		.ScheduleChange input:hover
		{
		cursor:pointer;
		}
	</style>
</head>
<body>
	<div align="center">
	<h1>スケジューラー</h1>
	<h2><%=year %>年<%=month %>月<%=date %>日のスケジュール</h2>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>時間</th><th>内容</th>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 0 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getZero()==null){ %>
						<%}else{ %> <%=daySchedule.getZero() %><% }%>>
					<input type="submit" value = "0:00~1:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getZero() != null){%>
					<%=daySchedule.getZero() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 1 >
					<input type="hidden" name="schedule" value =<% if(daySchedule.getOne()==null){ %>
						<%}else{ %> <%=daySchedule.getOne() %><% }%>>
					<input type="submit" value = "1:00~2:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getOne() != null){%>
					<%=daySchedule.getOne() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 2 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwo()==null){ %>
						<%}else{ %> <%=daySchedule.getTwo() %><% }%>>
					<input type="submit" value = "2:00~3:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwo() != null){%>
					<%=daySchedule.getTwo() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 3 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getThree()==null){ %>
						<%}else{ %> <%=daySchedule.getThree() %><% }%>>
					<input type="submit" value = "3:00~4:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getThree() != null){%>
					<%=daySchedule.getThree() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 4 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getFour()==null){ %>
						<%}else{ %> <%=daySchedule.getFour() %><% }%>>
					<input type="submit" value = "4:00~5:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getFour() != null){%>
					<%=daySchedule.getFour() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 5 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getFive()==null){ %>
						<%}else{ %> <%=daySchedule.getFive() %><% }%>>
					<input type="submit" value = "5:00~6:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getFive() != null){%>
					<%=daySchedule.getFive() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd ><input type="hidden" name="sTime" value = 6 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getSix()==null){ %>
						<%}else{ %> <%=daySchedule.getSix() %><% }%>>
					<input type="submit" value = "6:00~7:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getSix() != null){%>
					<%=daySchedule.getSix() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 7 >
					<input type="hidden" name="schedule" value =<% if(daySchedule.getSeven()==null){ %>
						<%}else{ %> <%=daySchedule.getSeven() %><% }%>>
					<input type="submit" value = "7:00~8:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getSeven() != null){%>
					<%=daySchedule.getSeven() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd ><input type="hidden" name="sTime" value = 8 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getEight()==null){ %>
						<%}else{ %> <%=daySchedule.getEight() %><% }%>>
					<input type="submit" value = "8:00~9:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getEight() != null){%>
					<%=daySchedule.getEight() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd ><input type="hidden" name="sTime" value = 9 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getNine()==null){ %>
						<%}else{ %> <%=daySchedule.getNine() %><% }%>>
					<input type="submit" value = "9:00~10:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getNine() != null){%>
					<%=daySchedule.getNine() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd ><input type="hidden" name="sTime" value = 10 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTen()==null){ %>
						<%}else{ %> <%=daySchedule.getTen() %><% }%>>
					<input type="submit" value = "10:00~11:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTen() != null){%>
					<%=daySchedule.getTen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 11 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getEleven()==null){ %>
						<%}else{ %> <%=daySchedule.getEleven() %><% }%>>
					<input type="submit" value = "11:00~12:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getEleven() != null){%>
					<%=daySchedule.getEleven() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 12 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwelve()==null){ %>
						<%}else{ %> <%=daySchedule.getTwelve() %><% }%>>
					<input type="submit" value = "12:00~13:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwelve() != null){%>
					<%=daySchedule.getTwelve() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 13 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getThirteen()==null){ %>
						<%}else{ %> <%=daySchedule.getThirteen() %><% }%>>
					<input type="submit" value = "13:00~14:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getThirteen() != null){%>
					<%=daySchedule.getThirteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 14 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getFourteen()==null){ %>
						<%}else{ %> <%=daySchedule.getFourteen() %><% }%>>
					<input type="submit" value = "14:00~15:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getFourteen() != null){%>
					<%=daySchedule.getFourteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 15 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getFifteen()==null){ %>
						<%}else{ %> <%=daySchedule.getFifteen() %><% }%>>
					<input type="submit" value = "15:00~16:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getFifteen() != null){%>
					<%=daySchedule.getFifteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 16 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getSixteen()==null){ %>
						<%}else{ %> <%=daySchedule.getSixteen() %><% }%>>
					<input type="submit" value = "16:00~17:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getSixteen() != null){%>
					<%=daySchedule.getSixteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 17 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getSeventeen()==null){ %>
						<%}else{ %> <%=daySchedule.getSeventeen() %><% }%>>
					<input type="submit" value = "17:00~18:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getSeventeen() != null){%>
					<%=daySchedule.getSeventeen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 18 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getEighteen()==null){ %>
						<%}else{ %> <%=daySchedule.getEighteen() %><% }%>>
					<input type="submit" value = "18:00~19:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getEighteen() != null){%>
					<%=daySchedule.getEighteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 19 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getNineteen()==null){ %>
						<%}else{ %> <%=daySchedule.getNineteen() %><% }%>>
					<input type="submit" value = "19:00~20:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getNineteen() != null){%>
					<%=daySchedule.getNineteen() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 20 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwenty()==null){ %>
						<%}else{ %> <%=daySchedule.getTwenty() %><% }%>>
					<input type="submit" value = "20:00~21:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwenty() != null){%>
					<%=daySchedule.getTwenty() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 21 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwentyone()==null){ %>
						<%}else{ %> <%=daySchedule.getTwentyone() %><% }%>>
					<input type="submit" value = "21:00~22:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwentyone() != null){%>
					<%=daySchedule.getTwentyone() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 22 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwentytwo()==null){ %>
						<%}else{ %> <%=daySchedule.getTwentytwo() %><% }%>>
					<input type="submit" value = "22:00~23:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwentytwo() != null){%>
					<%=daySchedule.getTwentytwo() %>
				<%} %>
			</td>
		</tr>
		<tr>
			<td class = "jikan">
				<form class ="ScheduleChange" action="/schedule/ScheduleChange" method="post">
					<input type="hidden" name="ymd" value = ymd >
					<input type="hidden" name="sTime" value = 23 >
					<input type="hidden" name="schedule" value = <% if(daySchedule.getTwentythree()==null){ %>
						<%}else{ %> <%=daySchedule.getTwentythree() %><% }%>>
					<input type="submit" value = "23:00~0:00">
				</form>
			</td>
			<td class ="naiyou">
				<% if(daySchedule.getTwentythree() != null){%>
					<%=daySchedule.getTwentythree() %>
				<%} %>
			</td>
		</tr>

	</table>
	<jsp:include page ="footer.jsp" />
	<a href="/schedule/Calender">戻る</a>
	</div>

</body>
</html>