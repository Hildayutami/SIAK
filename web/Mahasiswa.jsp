<%-- 
    Document   : Mahasiswa
    Created on : Jun 26, 2018, 5:11:54 AM
    Author     : hilda

readonly
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIAK</title>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="Resource/bootstrap.css" rel="stylesheet">
    </head>
    <body>
       
        <div class="container">
            
            <form method="POST" action='MahasiswaController' name="frmAddMahasiswa" role="form">

                <div class="form-group">
                    <label for="npm">
                        Npm: <input class="form-control" type="number" id="npm" name="npm" value=<c:out value="${mahasiswa.npm}" /> />
                    </label>
                </div>
                <div class="form-group">
                    <label for="nama">
                        Nama:<input class="form-control" type="text" id="nama" name="nama" value="<c:out value="${mahasiswa.nama}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="angkatan">
                        Angkatan: <input class="form-control" type="text" name="angkatan" value="<c:out value="${mahasiswa.angkatan}" />" /> 
                    </label>
                </div>
                <div class="form-group">
                    <label for="fakultas">
                        Fakultas: <input class="form-control" type="text" name="fakultas" value="<c:out value="${mahasiswa.fakultas}" />" />
                    </label>
                </div>
                <div class="form-group">
                    <label for="ipk">
                        Ipk: <input class="form-control" type="text" name="ipk" value="<c:out value="${mahasiswa.ipk}" />" />
                    </label>
                </div>

                <input type="submit" value="Submit" class="btn btn-info" />
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
