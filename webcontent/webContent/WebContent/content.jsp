<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.ResultSetMetaData" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="webContent.contentDAO" %>
	<%@ page import="webContent.BurgerInfo" %>
	<%@ page import="webContent.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%String no = request.getParameter("no");
int b_no;
if(no != null && no != "" && no != "null")
{
	try
	{
		b_no = Integer.parseInt(no);
		%>
		<%contentDAO a = new contentDAO(b_no); %>
		<%a.conn(); %>
		<%BurgerInfo b = a.getBurgerInfo(); %>
		<%UserInfo u = a.getUserInfo(); %>
		<%b.getName(); %>
		
		<table class="infobox vcard">
		<caption><span class="fn"><font size="5"><b><%=b.getName() %></b></font></span></caption>
		<tr>
		<td colspan="2" style="text-align: center;">
		<img alt="<%=b.getName() %>" src="<%=b.getImage() %>" width="180" height="207"  />
		</td>
		</tr>
		<tr>
		<th style="font-weight:bold;">�귣��</th>
		<td><%=b.getCompany() %></td>
		</tr>
		
		<tr>
		<th style="font-weight:bold;">Į�θ�(Kcal)</th>
		<td><%=b.getCalone() %>(��ǰ)<br><%=b.getCalset() %>(��Ʈ)</td>
		</tr>
		
		<tr>
		<th style="font-weight:bold;">����(KRW)</th>
		<td><%=b.getPriceone() %>(��ǰ)<br><%=b.getPriceset() %>(��Ʈ)</td>
		</tr>
		
		</table>
		<p>
		<%=b.getContent() %>
		</p>
		<br>
		<%=b.getModified()%>�� <%=u.getId() %>���� ����(E-mail : <%=u.getEmail() %>)
<%	}
	catch(Exception e)
	{
		%>Something Error.
		<%=no %>
		<%
	}
		
}%>
</body>
</html>