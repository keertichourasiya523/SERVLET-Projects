<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Car Details</h1>

<form action="add-car" method="post">

<input type = "number" placeholder="Enter Car Id" name = "carId"><br>
<input type="text" placeholder="Enter Model" name ="model"><br>
<input type="text" placeholder="Enter Brand" name ="brand"><br>
<input type="text" placeholder="Enter Color" name ="color"><br>
<input type="number" placeholder="Enter Price" name ="price"><br>
<input type="submit" value="ADD">

</form>
</body>
</html>