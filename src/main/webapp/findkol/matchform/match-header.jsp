<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MetHer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
 content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- 
 //////////////////////////////////////////////////////

 FREE HTML5 TEMPLATE 
 DESIGNED & DEVELOPED by FREEHTML5.CO
  
 Website:   http://freehtml5.co/
 Email:    info@freehtml5.co
 Twitter:   http://twitter.com/fh5co
 Facebook:   https://www.facebook.com/fh5co

 //////////////////////////////////////////////////////
  -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link
 href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700'
 rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento"
 rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
 href="<%=request.getContextPath()%>/resources/css/style.css">

<!-- Modernizr JS -->
<script
 src="<%=request.getContextPath()%>/resources/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
 <script src="js/respond.min.js"></script>
 <![endif]-->
<style type="text/css"></style>
</head>
<body>

 <div class="fh5co-loader"></div>

 <div id="page">
  <nav class="fh5co-nav" role="navigation">
   <div class="container">
    <div class="row">
     <div class="col-xs-2">
      <div id="fh5co-logo">
       <a href="<%=request.getContextPath()%>/metherIndex.jsp">MetHer<strong>.</strong></a>
      </div>
     </div>
     <div style="margin-left: 450px">
      <ul>
       <li>
        <FORM METHOD="post"
         ACTION="<%=request.getContextPath()%>/serch.do">
         <input type="text" name="search"> <input type="hidden"
          name="action" value="getSearch"> <input type="submit"
          value="送出">
        </FORM>
       </li>

      </ul>
     </div>

     <div class="col-xs-10 text-right menu-1">
      <ul>
       <li class="active"><a
        href="<%=request.getContextPath()%>/metherIndex.jsp">首頁</a></li>
       <li><a href="about.html">找廠商</a></li>
       <li><a href="services.html">找網紅</a></li>
       <li class="has-dropdown active"><a
        href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員中心</a>
        <ul class="dropdown">
         <li><a
          href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員註冊</a></li>
         <li><a
          href="<%=request.getContextPath()%>/login/companyMebJspLogin.jsp">會員登入</a></li>
         <li><a href="#">會員中心</a></li>
         <li><a
          href="<%=request.getContextPath()%>/logout/companyMebJspLogout.jsp">會員登出</a></li>
        </ul></li>
       <li class="has-dropdown active"><a
        href="<%=request.getContextPath()%>/index.html">聊天室</a>
        <ul class="dropdown">
         <li><a href="<%=request.getContextPath()%>/index.html">公共聊天室</a></li>
         <li><a href="<%=request.getContextPath()%>/index.jsp">私人聊天室</a></li>
        </ul></li>
      </ul>
     </div>
    </div>

   </div>
  </nav>