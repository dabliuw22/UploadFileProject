<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Upload File</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
	<h2>${noticia.titulo}</h2>
	<form:form method="POST" modelAttribute="imagen" enctype="multipart/form-data">
		<label>Imagen</label>
		<form:input path="file" id="file" type="file" name="file"/>
		<form:errors path="file"></form:errors>
		<input type="submit" value="Crear"/>
	</form:form>	
</body>
</html>