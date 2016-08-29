<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informasi Data Mahasiswa</title>
    </head>
    <body>
        <div>
            <label>Kode: ${mahasiswa.id}</label>
        </div>
        <div>
            <label>NIM: ${mahasiswa.nim}</label>
        </div>
        <div>
            <label>Nama: ${mahasiswa.nama}</label>
        </div>
    </body>
</html>