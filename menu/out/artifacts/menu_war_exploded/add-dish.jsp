<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add dish</title>
</head>
<body>
<form action="/add_dish" method="post">
        <pre>
Dish name:  <input type="text" name="dish-name" placeholder="Enter dish name..."><br/>
Weight:     <input type="number" name="weight" placeholder="Enter weight..."><br/>
Price:      <input type="number" step="0.01" name="price" placeholder="Enter price..."><br/>
Discount:   <input type="number" name="discount" placeholder="Enter value of discount..."><br/>
<input type="submit" value="Add to menu">
        </pre>
</form>
</body>
</html>
