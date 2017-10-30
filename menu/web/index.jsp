<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<a href="add-dish.jsp">Add dish to menu.</a>
<form action="/param" method="get">
    <pre>
Price from: <input type="number" name="from-price" placeholder="from..."><br/>
Price to:   <input type="number" name="to-price" placeholder="to..."><br/>
Less then:  <input type="number" name="less-then" placeholder="Input i grams..."><br/>
    </pre>
    <button type="submit" name="show-filtered-menu" value="show">Show menu</button>
</form>
<form action="/withDiscount?discount=true" method="get">
    <button type="submit" name="show-discount-menu" value="true">Show discount menu</button>
</form>

<c:if test="${menuList ne null}">
    <c:choose>
        <c:when test="${menuList.size() > 0}">
            <table border="1">
                <tr>
                    <td>Dish</td>
                    <td>Weight</td>
                    <td>Price</td>
                    <td>Discount</td>
                </tr>
                <c:forEach items="${menuList}" var="item">
                    <tr>
                        <td><c:out value="${item.dishName}"/></td>
                        <td><c:out value="${item.weight}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <td><c:out value="${item.discount}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <c:out value="No dishes... =("/>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
