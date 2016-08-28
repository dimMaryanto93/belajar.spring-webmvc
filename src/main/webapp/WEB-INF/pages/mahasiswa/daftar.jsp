<%@page import="java.util.List"%>
<%@page import="spring.mvc.belajar.domain.Mahasiswa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Mahasiswa> daftarMahasiswa = (List<Mahasiswa>) request.getAttribute("daftarMahasiswa");
	%>
	<table>
		<tr>
			<th>NIM</th>
			<th>Nama</th>
		</tr>
		<%
			for (Mahasiswa mhs : daftarMahasiswa) {
		%>
		<tr>
			<td><%=mhs.getNim()%></td>
			<td><%=mhs.getNama()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>