<%@ page import="com.match_form.model.MatchFormVO"%>
<%@ page import="com.match_form.model.MatchService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.*"%>
<%@ page import="com.companymeb.model.*"%>
<%@ page import="com.kolmeb.model.KolMebVO"%>
<%@ page import="com.match_form.*"%>
<%@ page import="com.product.model.*"%>




<%@ include file="header.jsp"%>

<%
MatchService matchService = new MatchService();
List <ProductVO> list = matchService.getOneMatchForm(kolMebVO.getKol_idnum());
pageContext.setAttribute("list", list);
%>

<body bgcolor='white'>
	<div class="content-wrapper">




		<div class="row">
			<div class="col-12 table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>No.</th>
							<th>標題</th>
							<th>產品網址</th>
							<th>工作內容</th>
							<th>工作申請</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productVO" items="${list}" varStatus="s"> 
							<tr>
								<td>${s.index+1}</td>
								<td>${productVO.product_name}</td>
								<td>${productVO.product_link}</td>
								<td>${productVO.product_introduce}</td>
								
								
								<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/matchform/match.do"
										style="margin-bottom: 0px;">
								<td>
								<input type="submit" value="移除邀約" class="btn btn-block btn-danger">
								<input type="hidden" name="product_num"	value="${productVO.product_num}">
								<input type="hidden" name="action" value="delete">
								</td>
								</FORM>
								
							</tr>
						 </c:forEach> 
					</tbody>
				</table>
			</div>

		</div>
	</div>

</body>


<%@ include file="footer.jsp"%>