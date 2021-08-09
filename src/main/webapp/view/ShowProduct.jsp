<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 8/9/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ManageProduct</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .addBtn {
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">List Products</h2>
    <p>Vui lòng thêm sản phẩm tại đây: <a href="/product?action=create" class="btn btn-success addBtn">Add New Product</a></p>
    <div style="display: inline-block">
        <p>Hoặc thử tìm kiếm sản phẩm tại đây:
        <form action="/product?action=findByName" method="get">
            <input type="text" placeholder="Search" name="fName">
            <input type="text" hidden name="action" value="findByName">
            <button class="btn btn-info ml-1" type="submit">Search</button>
        </form>
    </div>
    </p>
    <table class="table table-striped text-center">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Màu sắc</th>
            <th>Mô tả</th>
            <th>Danh mục</th>
            <th colspan="2">Option</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listProduct}" var="p">
            <tr>
                <td>${p.idsp}</td>
                <td>${p.tensp}</td>
                <td>${p.gia}</td>
                <td>${p.soluong}</td>
                <td>${p.mausac}</td>
                <td>${p.mota}</td>
                <td>${p.danhmuc}</td>
                <td><a href="/product?action=delete&idsp=${p.idsp}" class="btn btn-danger" onclick="return confirm('Sản phẩm này sẽ bị xóa, bạn chắc chứ')">Delete</a></td>
                <td><a href="/product?action=update&idsp=${p.idsp}" class="btn btn-warning">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

