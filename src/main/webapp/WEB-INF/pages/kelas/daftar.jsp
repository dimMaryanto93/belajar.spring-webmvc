<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Kelas</title>
        <%@include file="../layout/header.jsp" %>
    </head>
    <body class="container">
        <h3>Daftar Kelas</h3>

        <table border="1">
            <thead>
                <tr class="center">
                    <th>Kode Kelas</th>
                    <th>Nama Nama</th>
                    <th>Kode Jurusan</th>
                    <th>Nama Jurusan</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${daftarKelas}" var="kelas">
                    <tr>
                        <td>${kelas.kode}</td>
                        <td>${kelas.nama}</td>
                        <td>${kelas.jurusan.kode}</td>
                        <td>${kelas.jurusan.nama}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
