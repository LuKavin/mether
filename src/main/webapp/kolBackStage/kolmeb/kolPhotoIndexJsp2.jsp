<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ page import="com.memberphoto.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
KolMebVO mebVO = (KolMebVO) session.getAttribute("kolMebVO");
MemberPhotoService memberPhotoService = new MemberPhotoService();
List<MemberPhotoVO> list = memberPhotoService.getKolAll(mebVO.getKol_idnum());
pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>所有會員照片</title>

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
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #000;
}

th, td {
	padding: 5px;
	text-align: center;
}

</style>

<style>

.fivepicsonly {
	color: blue;
	display: inline;
}

.addpic{
  text-align: left;
}

.addpart2{
  text-align: left;
}

.uploadpic{
	margin-left: 2px;
}

.addmemphoto{
	text-align: left;
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
							<a href="index.html">MetHer<strong>.</strong></a>
						</div>
					</div>
					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">Story</a></li>
							<li class="has-dropdown"><a href="services.html">Services</a>
								<ul class="dropdown">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">eCommerce</a></li>
									<li><a href="#">Branding</a></li>
									<li><a href="#">API</a></li>
								</ul></li>
							<li class="has-dropdown active"><a href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員中心</a>
								<ul class="dropdown">
									<li><a href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員註冊</a></li>
									<li><a href="<%=request.getContextPath()%>/login/companyMebJspLogin.jsp">會員登入</a></li>
									<li><a href="#">會員中心</a></li>
									<li><a href="<%=request.getContextPath()%>/logout/companyMebJspLogout.jsp">會員登出</a></li>
								</ul></li>
							<li><a href="contact.html">Contact</a></li>
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
							<h1>所有會員照片</h1>
<!-- 							<h4 class="fivepicsonly">(照片最多只能上傳5張)</h4> -->
							<p></p>
							
							<div class="addmemphoto">
							<font size="3px"><a href='<%=request.getContextPath()%>/kolBackStage/kolmeb/kolPhotoAddJsp2.jsp' class="addlink">新增會員照片(最多只能新增5張)</a></font>
							</div>
							
<!-- 							<div class="addpart1"> -->
<!-- 							<div class="row mb-3"></div> -->
<!-- 								<div class="col-md-10"></div> -->
<!-- 									<input type="file" id="p_file"> -->
<!-- 							</div> -->
						</div>
							
					</div>
							
							<table>
								<tr>
									<td width="200px">會員照片</td>
									<td width="200px">修改</td>
									<td width="200px">刪除</td>
								</tr>
								
							<c:forEach var="memberPhotoVO" items="${list}">

								<tr class="countrow">
									<td>
										<img style="max-width: 70px; min-height: 70px"
										 src="<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${memberPhotoVO.meb_photonum}">
				                   	</td>
									<td>
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/memberphoto/MemberPhoto.do" style="margin-bottom: 0px;">
									<input type="submit" value="修改">
									<input type="hidden" name="meb_photonum" value="${memberPhotoVO.meb_photonum}"> 
									<input type="hidden" name="action" value="getOne_For_Update_kol">
									</FORM>
									</td>
									<td>
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/memberphoto/MemberPhoto.do" style="margin-bottom: 0px;">
									<input type="submit" value="刪除">
									<input type="hidden" name="meb_photonum" value="${memberPhotoVO.meb_photonum}"> 
									<input type="hidden" name="action" value="delete_kol">
									</FORM>
									</td>							
								</tr>
								
							</c:forEach>
							</table>
							
<!-- 							<div class="row"> -->
<!-- 								<div class="col-md-12"> -->
<!-- 									<button type="submit" class="btn btn-primary" id="C_picture_save">儲存</button> -->
<!-- 								</div> -->
<!-- 							</div> -->
							

						</div>
					</div>
				</div>

<!--========================================footer part========================================-->

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; 2016 Free HTML5. All Rights
								Reserved.</small> <small class="block">Designed by <a
								href="http://freehtml5.co/" target="_blank">FREEHTML5.co</a>
								Demo Images: <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
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
	    
	    <script>	    
			if($('.countrow').length>=5){
				// $('.addlink').
				$(".addlink").click(function(event){
				event.preventDefault();
				});
			}
		</script>

</body>
</html>