<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update data mahasiswa</title>
</head>

<body>
	<form:form action="do-updated" method="post">
		<form:hidden path="id" />
		<form:input path="nim" readonly="true" maxlength="8" size="10" />
		<form:input path="nama" />
		<input type="submit" value="Kirim">
	</form:form>

</body>
</html>