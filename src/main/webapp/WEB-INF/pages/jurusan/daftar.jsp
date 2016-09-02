<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Jurusan</title>
        <%@include file="../layout/header.jsp" %>
    </head>
    <body class="container">
        <h3>Daftar Jurusan</h3>

        &nbsp;
        <a href="<spring:url value="/jurusan/tambah"/>" class="btn waves-effect waves-light">
            Tambah
        </a>
        <table border="0">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${daftarJurusan}" var="jurusan">
                    <tr>
                        <td>${jurusan.kode}</td>
                        <td>${jurusan.nama}</td>
                        <td>
                            <a href="<spring:url value="/jurusan/ubah-${jurusan.id}"/>">
                                <i class="material-icons">mode_edit</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>