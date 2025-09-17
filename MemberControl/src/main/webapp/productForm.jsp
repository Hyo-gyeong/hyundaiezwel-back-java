<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 등록창</title>
</head>
<body>
<form method="post" action="${contextPath}/product/addProduct.do">
    <h1 style="text-align:center">상품 등록창</h1>
    <table align="center">
        <tr>
            <td width="200"><p align="right">상품 번호</td>
            <td width="400"><input type="text" name="prdNo"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">상품명</td>
            <td width="400"><input type="text" name="prdName"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">가격</td>
            <td width="400"><input type="number" name="prdPrice"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">제조사</td>
            <td width="400"><input type="text" name="prdMaker"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">색상</td>
            <td width="400"><input type="text" name="prdColor"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">카테고리 번호</td>
            <td width="400"><input type="number" name="ctgNo"></td>
        </tr>
        <tr>
            <td width="200"><p>&nbsp;</p></td>
            <td width="400">
                <input type="submit" value="상품 등록">
                <input type="reset" value="다시입력">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
