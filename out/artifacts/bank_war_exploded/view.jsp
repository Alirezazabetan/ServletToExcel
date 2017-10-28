
<%@page import="banking.controller.*" %>
<%@page import="banking.entity.*" %>

<%
     String number = request.getParameter("number");
     if ( number == null || number.equals("") ) number = "1234";
     int num = Integer.parseInt(number);
     BankAccount ba = new BankAccountController().findByNumber(num);    
        
%>
    

<html>
    <form action="view.jsp" method="GET">
        Number: <input type="text" name="number" value="<%=ba.getNumber()%>"> <br>
        Owner:  <input type="text" name="owner" value="<%=ba.getOwner()%>"> <br>
        Balance:<input type="text" name="balance" value="<%=ba.getBalance()%>"> <br>
        <input type="submit" value="View"> <br>
    </form>    
</html>
