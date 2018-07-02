<%-- 
    Document   : ListMahasiswa
    Created on : Jun 26, 2018, 5:07:00 AM
    Author     : hilda
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
        <title>SIAK</title>

        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="bootstrap.css" rel="stylesheet">
    </head>
    <body>
    <div style="text-align: left"><a href="LogoutController">Logout</a></div>

    <h3><center> Data Mahasiswa <center></h3><br><br>
                <div class="wrap">
                    <section>
                        <div class="container">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                            NPM
                                        </th>
                                        <th>
                                            Nama
                                        </th>
                                        <th>
                                            Angkatan
                                        </th>
                                        <th>
                                            Fakultas
                                        </th>
                                        <th>
                                            IPK
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${mahasiswa}" var="mhs">
                                        <tr>
                                            <td>
                                                <c:out value="${mhs.npm}"/>
                                            </td>
                                            <td>
                                                <c:out value="${mhs.nama}"/>
                                            </td>
                                            <td>
                                                <c:out value="${mhs.angkatan}"/>
                                            </td>
                                            <td>
                                                <c:out value="${mhs.fakultas}"/>
                                            </td>
                                            <td>
                                                <c:out value="${mhs.ipk}"/>
                                            </td>
                                            <td><a href="MahasiswaController?action=edit&npm=<c:out value="${mhs.npm}"/>">Update</a></td>
                                            <td><a href="MahasiswaController?action=delete&npm=<c:out value="${mhs.npm}"/>">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <a href="MahasiswaController?action=insert" role="button" class="btn btn-info btn-lg" data-toggle="modal">Tambah Mahasiswa</a>	
                        </div>
                    </section>	
                </div>

                <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
                <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

                </body>
                </html>
