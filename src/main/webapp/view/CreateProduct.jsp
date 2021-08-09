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
    <title>Create Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Thêm sản phẩm</h2>
    <form action="/product?action=create" method="post">
        <table class="table table-striped text-center">
            <thead>
            <tr>
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
                <td><input type="text" placeholder="Nhập tên" name="tensp"></td>
                <td><input type="text" placeholder="Nhập giá" name="gia"></td>
                <td><input type="text" placeholder="Nhập số lượng" name="soluong"></td>
                <td><input type="text" placeholder="Nhập màu sắc" name="mausac"></td>
                <td><input type="text" placeholder="Nhập mô tả" name="mota"></td>
                <td>
                    <select name="danhmuc">
                        <option disabled="disabled" selected>Chọn danh mục</option>
                        <c:forEach items="${listCategory}" var="c">
                            <option value="${c}">${c}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Thêm</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>
