<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");

String id = request.getParameter("id");
int age = Integer.parseInt(request.getParameter("age"));
String[] fruit = request.getParameterValues("fruit");

String color = age==10 ? "pink" : "cyan";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=name%>(<font color="<%=color%>"><%=id%></font>)님 안녕하세요.<br/>
당신이 좋아하는 과일은
<%
		if(fruit != null) { // 선택된 체크박스 있는 경우
			int len = fruit.length;	// fruit가 null인 경우 NllPointException 발생하므로, if문 내부에 있어야 함
			if(len>1) {	//선택된 체크박스가 2개 이상인 경우
				for(int i=0;i<len;i++) {
					out.print(fruit[i]);
					if(i != len-1) {
						out.print(", ");
					}
				}
			}
			out.print("입니다.");	// 배열의 마지막 인덱스는 length-1이므로
			
		} else {	// 선택된 체크박스가 없는 경우(fruit가 null인 경우)
%>
		없습니다.
<%
		}
%>

</body>
</html>