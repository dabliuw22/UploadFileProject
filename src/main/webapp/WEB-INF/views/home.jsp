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
	<h2>Noticia Nueva</h2>
	<form:form method="POST" modelAttribute="noticia" enctype="multipart/form-data">
		<label>Titulo</label>
		<form:input path="titulo" id="titulo" type="text" name="titulo"/>
		<form:errors path="titulo"></form:errors>
		<label>Resumen</label>
		<form:input path="resumen" id="resumen" type="text" name="resumen"/>
		<form:errors path="resumen"></form:errors>
		<label>Contenido</label>
		<form:input path="contenido" id="contenido" type="textarea" name="contenido"/>
		<form:errors path="contenido"></form:errors>
		<input type="submit" value="Crear"/>
	</form:form>
	<h2>Noticias</h2>
	<table>
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Imagen</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${noticias}" var="n">
			<tr>
				<td>${n.titulo}</td>
				<td><img src="data:image/png;base64,${n.encode}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
</body>
</html>