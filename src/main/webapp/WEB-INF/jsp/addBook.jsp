<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Registration</title>
</head>
<body>
 
     <form:form id="regForm1" modelAttribute="book" action="bookregistration" method="post">
                <table align="center">
                
                    <tr>
                        <td>
                            <form:label path="Bookname">Book Name</form:label>
                        </td>
                        <td>
                            <form:input path="Bookname" name="Bookname" id="Bookname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="Booktype">Book Type</form:label>
                        </td>
                        <td>
                            <form:input path="Booktype" name="Booktype" id="Booktype" />
                        </td>
                    </tr>
                   
                    
                    <tr>
                        <td>
                            <form:label path="Price">Price</form:label>
                        </td>
                        <td>
                            <form:input path="Price" name="Price" id="Price" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="Description">Book Description</form:label>
                        </td>
                        <td>
                            <form:input path="Description" name="Description" id="Description" />
                        </td>
                    </tr>
                    
           
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Submit" /> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>
</body>
</html>