<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
    <head>
        <title>Informasi Data Mahasiswa</title>
        <%@include file="../layout/header.jsp" %>
    </head>
    <body class="container">
        <h3>Informasi Mahasiswa</h3>
        <springf:form commandName="mahasiswa">
            <div class="input-field">
                <springf:input path="id" readonly="true"/>
                <springf:label path="id" >Kode Mahasiswa</springf:label>
            </div>
            <div class="row">                
                <div class="input-field col s12 m4 l4">
                    <i class="material-icons prefix">account_circle</i>
                    <springf:input path="nim" readonly="true"/>
                    <springf:label path="nim">Nim</springf:label>
                </div>
                <div class="input-field col s12 m8 l8">
                    <springf:input path="nama" readonly="true"/>
                    <springf:label path="nama">Nama Mahasiswa</springf:label>
                </div>
                <div class="row right">
                    <a class="btn" href="<spring:url value="/mahasiswa/daftar"></spring:url>">Kembali</a>
                </div>
            </div>
        </springf:form>
    </body>
</html>