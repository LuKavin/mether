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
							<p style="font-size:40px">所有會員照片</p>
							<p></p>
							
							<div class="addmemphoto">
							<font size="3px"><a href='<%=request.getContextPath()%>/comBackStage/companymeb/companyPhotoAddJspTwo.jsp' class="addlink">新增會員照片(最多只能新增5張)</a></font>
							</div>
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
									<input type="hidden" name="action" value="getOne_For_Update">
									</FORM>
									</td>
									<td>
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/memberphoto/MemberPhoto.do" style="margin-bottom: 0px;">
									<input type="submit" value="刪除">
									<input type="hidden" name="meb_photonum" value="${memberPhotoVO.meb_photonum}"> 
									<input type="hidden" name="action" value="delete">
									</FORM>
									</td>							
								</tr>
								
							</c:forEach>
							</table>
						</div>
					</div>
				</div>
				
				</section>
			</div>


	

			<%@ include file="footer.jsp"%>
