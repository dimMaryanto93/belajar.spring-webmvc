<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<!--Let browser know website is optimized for mobile-->

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href='<spring:url value="/webjars/materializecss/0.97.5/css/materialize.min.css"></spring:url>'
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript"
	src='<spring:url value="/webjars/jquery/3.1.0/jquery.min.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="/webjars/materializecss/0.97.5/js/materialize.min.js"></spring:url>'></script>



<title>Daftar Mahasiswa</title>
</head>
<body class="container">

	<h2>Daftar mahasiswa</h2>
	
	<a href="<spring:url value="/mahasiswa/reg"/>" class="btn">Tambah data
		Mahasiswa</a>

	<table class="table table-bordered table-condensed table-responsive">
		<tr>
			<th class="base">Kode</th>
			<th>NIM</th>
			<th>Nama</th>
			<th>Aksi</th>
		</tr>
		<c:forEach items="${ daftarMahasiswa }" var="mhs">
			<tr>
				<td><c:out value="${ mhs.id }" /></td>
				<td><c:out value="${ mhs.nim }" /></td>
				<td><c:out value="${ mhs.nama }" /></td>
				<td><a
					href='<spring:url value="/mahasiswa/info-${ mhs.nim }"/>'>Detail
						Mahasiswa</a> &nbsp; <a
					href='<spring:url value="/mahasiswa/update-${ mhs.nim }"/>'>Update</a>
					&nbsp; <a
					href='<spring:url value="/mahasiswa/hapus-${ mhs.nim }"/>'>Hapus</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>