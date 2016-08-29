<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>



<html>
    <head>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Mahasiswa</title>
    </head>
    <body class="container">
        <table class="table table-bordered table-condensed table-responsive">
            <tr>
                <th class="base">Kode</th>
                <th>NIM</th>
                <th>Nama</th>
            </tr>
            <c:forEach items="${ daftarMahasiswa }" var="mhs">
                <tr>
                    <td><c:out value="${ mhs.id }" /></td>
                    <td><c:out value="${ mhs.nim }" /></td>
                    <td><c:out value="${ mhs.nama }" /></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>