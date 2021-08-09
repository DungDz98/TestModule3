<%--
  Created by IntelliJ IDEA.
  User: dungn
  Date: 8/9/2021
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<div class="container-fluid">
    <h2 class="text-center">Cập nhật sản phẩm</h2>
    <form method="post">
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
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input style="width: 65px;" type="text" placeholder="Nhập id" name="idsp" value="${productOld.idsp}" readonly></td>
                <td><input type="text" placeholder="Nhập tên" name="tensp" value="${productOld.tensp}"></td>
                <td><input type="text" placeholder="Nhập giá" name="gia" value="${productOld.gia}"></td>
                <td><input type="text" placeholder="Nhập số lượng" name="soluong" value="${productOld.soluong}"></td>
                <td><input type="text" placeholder="Nhập màu sắc" name="mausac" value="${productOld.mausac}"></td>
                <td><input type="text" placeholder="Nhập mô tả" name="mota" value="${productOld.mota}"></td>
                <td>
                    <select name="danhmuc">
                        <option value="${productOld.danhmuc}" selected>${productOld.danhmuc}</option>
                        <c:forEach items="${listCategory}" var="c">
                            <option value="${c}">${c}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-warning">Update</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>
