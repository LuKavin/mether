<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ page import="com.memberphoto.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");
%>

<%
MemberPhotoVO memberPhotoVO = (MemberPhotoVO) request.getAttribute("memberPhotoVO");
%>

<html>
<head>
<title>會員照片修改</title>

<link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento" rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/animate.css">

<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/icomoon.css">

<!-- Bootstrap  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/style.css">

<!-- adminlte style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/adminlte.min.css">

<!-- Modernizr JS -->
<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/modernizr-2.6.2.min.js"></script>


<style>

table {
	width: 450px;
	background-color: white;
	margin-top: 20px;
	margin-bottom: 1px;
	margin-left: 160px;
}

table, th, td {
	border: 0px solid #CCCCFF;
	font-size: 15px;
}

th, td {
	padding: 10px;
	font-size: 15px;
}

</style>

<style>

#preview{
  border: 1px solid lightgray;
  width: 200px;
  min-height: 250px;
  position: relative;
  margin-top: 10px;
  margin-left: 140px;
}

#preview span.text{
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  z-index: -1;
  color: lightgray;
}

#preview img.preview_img{
  width: 100%;
}

.meb_idnum{
	text-align: left;
}

.meb_idnum_control{
 	margin-left: 100px;
}

.meb_uploadphoto{
	text-align: left;
}

.meb_uploadphoto_control{
 	margin-left: 100px;
}

</style>

</head>
<body>

<!--========================================header part========================================-->

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
							<li><a href="contact.html">關於我們</a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image: url(<%=request.getContextPath()%>/comBackStage/resourceslee/images/img_bg_1.jpg); height: 200px;">
		</header>

<!--========================================body part========================================-->

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>


		<div class="overlay"></div>
		<div class="fh5co-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<p></p>
							<h1>會員照片修改</h1>
							<p></p>

							<FORM METHOD="post" ACTION="MemberPhoto.do" name="form1" enctype="multipart/form-data">
							
							<table>
												
								<tr>
									<td>網紅照片:</td>
									<td><input type="file" name="meb_photo" id="upload" value="${memberPhotoVO.meb_photo}" onchange="loadImageFile(event)" size="50" /></td>
								</tr>
								
								<tr>
									<td>
<%-- 									<img id="image" style="max-width: 70px; min-height: 70px" src="<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${memberPhotoVO.meb_photonum}"> --%>
									<img id="image" style="max-width: 70px; min-height: 70px">
									</td>
								</tr>
					
							</table>
							
<!-- 								<div class="row mb-3"> -->
<!-- 									<label for="V_meb_photonum" class="col-md-2 col-form-label">照片編號:</label> -->
<!-- 									<div class="col-md-10"> -->
<%-- 										<input type="text" class="form-control" id="V_meb_photonum" name="meb_photonum" value="${memberPhotoVO.meb_photonum}" readonly="readonly"> --%>
<!-- 									</div> -->
<!-- 								</div> -->

<!-- 								<div class="row mb-3"> -->
<!-- 									<label for="V_com_idnum" class="col-md-2 col-form-label">廠商編號:</label> -->
<!-- 									<div class="col-md-10"> -->
<%-- 										<input type="text" class="form-control" id="V_com_idnum" name="com_idnum" value="${companyMebVO.com_idnum}" readonly="readonly"> --%>
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="row mb-3"> -->
<!-- 									<label for="p_file" class="col-md-2 col-form-label">廠商照片:</label> -->
<!-- 									<div class="col-md-10"> -->
<%-- 										<input type="file" id="p_file" name="meb_photo" onchange="loadImageFile(event)"  value="${memberPhotoVO.meb_photo}" size="50" /> --%>
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="row mb-3"> -->
<!-- 									<div class="col-md-10"> -->
<!-- 									<div id="preview"> -->
<!-- 										<span class="text">預覽圖</span> -->
<!-- 									</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
																
								<div class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary" id="V_addpic_submit">送出修改</button>
									</div>
								</div>
								<input type="hidden" name="meb_photonum" value="${meb_photonum}">
								<input type="hidden" name="action" value="update_kol">

							</FORM>
							
							<script>
									function loadImageFile(event) {
										var image = document.getElementById('image');
										image.src = URL.createObjectURL(event.target.files[0]);
									};
							</script>

						</div>							
					</div>
				</div>
			</div>
		</div>
<!--========================================footer part========================================-->

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; TGA_101_1 </small>
						</p>
						<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
						</p>
					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

<!--========================================else part========================================-->

		<!-- jQuery -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.min.js"></script>

		<!-- jQuery Easing -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.easing.1.3.js"></script>

		<!-- Bootstrap -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/bootstrap.min.js"></script>

		<!-- Waypoints -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.waypoints.min.js"></script>

		<!-- Carousel -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/owl.carousel.min.js"></script>

		<!-- countTo -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.countTo.js"></script>

		<!-- Stellar -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.stellar.min.js"></script>

		<!-- Magnific Popup -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.magnific-popup.min.js"></script>
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/magnific-popup-options.js"></script>

		<!-- Main -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/main.js"></script>
		
		<!-- js from IW -->
	    <script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/MemberInfo_IW.js"></script>

</body>
</html>