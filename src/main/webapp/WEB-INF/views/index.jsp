<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ru">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Парсер котировок</title>

  <!-- Основные js и css -->
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/my.style.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">

  <script src="<c:url value="/resources/js/jquery-3.1.0.min.js"/>"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/resources/js/my.script.js"/>"></script>

  <!-- Анимация загрузки ajax -->
  <link rel="stylesheet" href="<c:url value="/resources/css/jquery.faloading.css"/>">
  <script src="<c:url value="/resources/js/jquery.faloading.js"/>"></script>
</head>

<body>

  <div class="wrapper">
    <div class="container">
      <div><button type="button" class="btn btn-success addBtn" onclick="get_parse()">Котировки</button></div>
      <div class="row"></div>
    </div>
  </div>

</body>
</html>

