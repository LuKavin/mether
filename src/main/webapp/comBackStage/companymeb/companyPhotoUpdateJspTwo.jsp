<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.memberphoto.model.*"%>
<%@ include file="header.jsp"%>
<%
MemberPhotoVO memberPhotoVO = (MemberPhotoVO) request.getAttribute("memberPhotoVO");
%>


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
			<div class="content-wrapper">
				<section class="content">
						<div class="fh5co-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<p></p>
							<p style="font-size:40px">會員照片修改</p>
							<p></p>

							<FORM METHOD="post" ACTION="MemberPhoto.do" name="form1" enctype="multipart/form-data">
							
												
								<tr>
									<td><div class="h1">廠商照片</div></td>
									<td><input type="file" name="meb_photo" id="upload" value="${memberPhotoVO.meb_photo}" style="margin-left: 300px; margin-top: 20px" onchange="loadImageFile(event)" size="50" /></td>
								</tr>
								
								<tr>
									<td>
<%-- 										<img id="image" style="max-width: 70px; min-height: 70px" src="<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${memberPhotoVO.meb_photonum}"> --%>
										<img id="image" style="max-width: 120px; min-height: 120px; margin-top: 10px" >
									</td>
								</tr>
					
							
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
										<button type="submit" class="btn btn-primary" id="V_addpic_submit" style="margin-top: 20px">送出修改</button>
									</div>
								</div>
								<input type="hidden" name="meb_photonum" value="${meb_photonum}">
								<input type="hidden" name="action" value="update">

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
				</section>
			</div>



		
		
					<%@ include file="footer.jsp"%>
		