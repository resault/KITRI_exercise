<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
int result;
String color;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		
		<!-- out.println -->
		<h3>*** 구구단 ***</h3>
		<table width="900" height="700">
		<%
		for(int dan=2;dan<10;dan++) {
				out.print("<tr align=\"center\">");
				color = dan%2==0 ? "lightcoral  " : "lightskyblue  ";
			for(int i=1;i<10;i++){
				result = dan*i;
				out.print("<td bgcolor=\"" + color + "\">" + dan + " * " + i + " = " + result + "</td>");
			}
				out.print("</tr>");
		}
		%>
		</table>
		<hr>

		<!-- 출력태그 -->
		<h3>*** 구구단 ***</h3>
		<table width="900" height="700">
		<%
		for(int i=1;i<10;i++) {
		%>
			<tr>
		<%
			for(int dan=2;dan<10;dan++){
				color = dan%2==0 ? "lightcoral" : "lightskyblue";
				result = dan * i;
		%>
				<td bgcolor="<%=color%>" align="center"><%=dan%> * <%=i%> = <%=result%></td>
		<%			
			}
		%>
			 </tr>
		<%			
		}
		%>
		</table>
		<hr>



		<!-- 섞어쓰기 -->
		<h3>*** 구구단 ***</h3>
		<table width="900" height="700">
		<%
		for(int dan=2;dan<10;dan++) {
			color = dan%2==0 ? "lightcoral" : "lightskyblue";
		%>	
			<tr>
		<%
			for(int i=1;i<10;i++) {
				result = dan * i;
				out.print("<td bgcolor=\"" + color + "\" align=\"center\">" + dan + " * " + i + " = " + result + "</td>");
			}
		%>
			</tr>
		<%		
		}
		%>
		</table>
		<hr>
	</div>
</body>
</html>