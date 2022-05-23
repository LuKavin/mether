<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.memberphoto.model.*"%>

<%@ include file="header.jsp"%>

<%
CompanyMebVO mebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
MemberPhotoService memberPhotoService = new MemberPhotoService();
List<MemberPhotoVO> list = memberPhotoService.getComAll(mebVO.getCom_idnum());
pageContext.setAttribute("list", list);
%>



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
							<p style="font-size:40px">會員照片新增</p>
							<h2 class="fivepicsonly">(照片最多只能新增5張)</h2>
							<p></p>
													
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/memberphoto/MemberPhoto.do" name="form1" enctype="multipart/form-data">
							
					
								<tr>
									<td><div class="h1">廠商照片</div></td>
									<td><input type="file" name="meb_photo" id="upload" style="margin-left: 300px; margin-top: 20px" onchange="loadImageFile(event)" size="50" /></td>
								</tr>
								
								<tr>
									<td><img id="image" style="max-width: 120px; min-height: 120px; margin-top: 20px" src=""></td>
								</tr>
					
																					
<!-- 								<div class="row mb-3"> -->
<!-- 									<label for="V_com_idnum" class="col-md-2 col-form-label">廠商編號:</label> -->
<!-- 									<div class="col-md-10"> -->
<%-- 										<input type="text" class="form-control" id="V_com_idnum" name="com_idnum" value="${companyMebVO.com_idnum}" readonly="readonly"> --%>
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="row mb-3"> -->
<!-- 									<label for="p_file" class="col-md-2 col-form-label">廠商照片:</label> -->
<!-- 									<div class="col-md-10"> -->
<!-- 										<input type="file" id="p_file" name="meb_photo" onchange="loadImageFile(event)" size="50" /> -->
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
										<button type="submit" class="btn btn-primary" id="V_addpic_submit" style="margin-top: 20px">確認新增</button>
									</div>
								</div>
								
								<input type="hidden" name="action" value="insert">

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
