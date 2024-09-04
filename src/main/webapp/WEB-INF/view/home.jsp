<%@ page import="org.artsiomfilipchick.myweatherapp.objects.Data" %><%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 3.09.24
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyWeatherApp</title>
</head>
<body style="display: flex; flex-direction: column; justify-content: center; align-items: center">
    <H1>MyWeatherApp</H1>
    <div>
        <% Data data = (Data) request.getSession().getAttribute("data"); %>
        <% if (data != null) { %>
        <%      Data.Hourly hourlyObj = data.getHourly(); %>
        <%      for (int i = 0; i < hourlyObj.getTime().size(); i++) { %>
                    <h5><%= hourlyObj.getTime().get(i) %> - <%= hourlyObj.getTemperature().get(i) %> Cº</h5>
        <%      }%>
        <% } %>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/collect">
        <button type="submit">Получить данные</button>
    </form>
</body>
</html>
