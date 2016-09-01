<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="springtags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrasi Mahasiswa Baru</title>
    </head>
    <body>

        <form:form action="registered" method="post">

            <form:label path="nim">Nim:</form:label>
            <form:input path="nim" maxlength="8" size="10" />

            &nbsp;

            <form:label path="nama">Nama:</form:label>
            <form:input path="nama" size="25" />

            <input type="submit" value="Kirim" />

        </form:form>

    </body>
</html>