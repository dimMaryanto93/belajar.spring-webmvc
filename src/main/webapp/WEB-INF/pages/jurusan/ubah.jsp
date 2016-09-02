<%-- 
    Document   : tambah
    Created on : Sep 2, 2016, 9:54:33 AM
    Author     : dimmaryanto93
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah data Jurusan</title>
        <%@include file="../layout/header.jsp" %>
    </head>
    <body class="container">
        <h3>Ubah Data Jurusan</h3>
        <springf:form action="jurusanUpdate" commandName="jurusan" method="post">
            <div>
                <springf:hidden path="id"/>
            </div>
            <div class="row">
                <div class="input-field col s12 m4 l4">
                    <springf:label path="kode">Kode</springf:label>
                    <springf:input path="kode" maxlength="2" size="10"/>
                </div>
                <div class="input-field col s12 m8 l8">
                    <springf:label path="nama">Nama</springf:label>
                    <springf:input path="nama"/>
                </div>                
            </div>
            <div class="input-field right">
                <input class="btn waves-effect waves-light" type="submit" value="Kirim">
                &nbsp;
                <a href="<spring:url value="/jurusan/daftar"/>" class="btn waves-effect waves-light">Kembali</a>
            </div>
        </springf:form>
    </body>
</html>
