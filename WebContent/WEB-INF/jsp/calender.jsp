<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<style type="text/css">
<!--
    *{padding:5px; margin:0px;}
    body{text-align:center;}
    table{width:800px; background:white; border:2px black solid; border-collapse:collapse;}
    th{border:1px black solid; background:#CCFFFF;}
    td{border:1px black solid; text-align:right; padding:5px 20px 5px 20px;}
    br{line-height:1em;}
-->
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
<b><%= request.getAttribute("year") %>年<%=request.getAttribute("month") %>月のカレンダー</b>
<br/>
<br/>
<%= request.getAttribute("calender") %>
<br/>
<b>カレンダーの変更</b>
<br/>
<div style="text-align:center;">
<form action="/schedule/Calender" method="get">
<select id="year" name="year">
<%
    int year = Integer.parseInt(request.getAttribute("year").toString());
    int month = Integer.parseInt(request.getAttribute("month").toString());
    for(int i = year-10; i <= year+10; i++){
%>
<option value="<%=i %>"
<%
        if(i == year){
%>
selected
<%
        }
%>
><%=i %>年</option>
<%
    }
%>
</select>

<select id="moneth" name="month">
<%
    for(int i = 1; i <= 12; i++){
%>
<option value="<%=i %>"
<%
        if(i == month){
%>
selected
<%
        }
%>
><%=i %>月</option>
<%
    }
%>
</select>
<br/>
<br/>
<input type="submit" id="ok" name="ok" value="送信"/>
</form>
</div>
<jsp:include page ="footer.jsp" />
</div>

</body>
</html>