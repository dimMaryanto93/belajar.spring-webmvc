<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
    <head>
        <title>Daftar Mahasiswa</title>
        <%@ include file='../layout/header.jsp'%>
    </head>
    <body class="container">

        <h2>Daftar mahasiswa</h2>

        <a href="<spring:url value="/mahasiswa/reg"/>"
           class="btn waves-effect waves-light"><i class="material-icons">add</i>Tambah</a>

        <table class="table table-bordered table-condensed table-responsive">
            <tr>
                <th class="center">NIM</th>
                <th class="center">Nama</th>
                <th class="center">Aksi</th>
            </tr>
            <c:forEach items="${ daftarMahasiswa }" var="mhs">
                <tr>
                    <td><c:out value="${ mhs.nim }" /></td>
                    <td><c:out value="${ mhs.nama }" /></td>
                    <td class="right"><a class="btn waves-effect waves-light blue"
                                         href='<spring:url value="/mahasiswa/info-${ mhs.nim }"/>'> <i
                                class="material-icons">info</i></a> &nbsp; <a
                            class="btn waves-effect waves-light yellow"
                            href='<spring:url value="/mahasiswa/update-${ mhs.nim }"/>'> <i
                                class="material-icons">mode_edit</i></a> &nbsp; <a
                            class="btn waves-effect waves-light red"
                            href='<spring:url value="/mahasiswa/hapus-${ mhs.nim }"/>'> <i
                                class="material-icons">delete_forever</i></a></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>