<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data Mahasiswa</title>
        <%@include file="../layout/header.jsp" %>
    </head>
    <body class="container">
        <h3>Update data mahasiswa</h3>
        <springf:form action="do-updated" method="post">
            <div class="row">
                <springf:hidden path="id" />
            </div>
            <div class="row">                
                <div class="input-field col s12 m4 l4">
                    <i class="material-icons prefix">account_circle</i>
                    <springf:input path="nim" readonly="true"/>
                    <springf:label path="nim">Nim</springf:label>
                    </div>
                    <div class="input-field col s12 m8 l8">
                    <springf:input path="nama"/>
                    <springf:label path="nama">Nama Mahasiswa</springf:label>
                    </div>
                </div>
                <div class="row right">
                    <input class="btn green" type="submit" value="Kirim" />
                    <a class="btn" href="<spring:url value="/mahasiswa/daftar"></spring:url>">Kembali</a>
                </div>
        </springf:form>

    </body>
</html>