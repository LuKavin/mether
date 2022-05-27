
<%@page import="com.match_form.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.companymeb.model.*"%>
<%@page import="com.kolmeb.model.KolMebVO"%>
<%@page import="java.util.List"%>
<%@ page import="com.companyfavorite.model.*"%>
<%@page import="com.product.model.ProductVO"%>
<%@page import="com.product.model.ProductService"%>
<%@ include file="header.jsp"%>
<%
CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
%>
<%
MatchService matchService = new MatchService();
List list = matchService.getOneMatchForm(companyMebVO.getCom_idnum());
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html class="no-js">

<title>工作申請列表</title>

<body>
	<div class="content-wrapper">

		<div class="row">
			<div class="col-12 table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th style="font-size: 30px">No.</th>
							<th style="font-size: 30px">標題</th>
							<th style="font-size: 30px">商品價格</th>
							<th style="font-size: 30px">工作簡介</th>
							<th></th>
							<th style="font-size: 30px">接受應徵</th>
							<th style="font-size: 30px">拒絕應徵</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productVO" items="${list}" varStatus="s">
							<tr>
								<td>${s.index+1}</td>
								<td>${productVO.product_name}</td>
								<td>${productVO.product_budget}</td>
								<td>${productVO.product_introduce}</td>
								<td>${productVO.product_deadline}</td>
								
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/hireform/hire.do"
									style="margin-bottom: 0px;">
									<td><input type="submit" value="接受應徵"
										class="btn btn-block btn-success"> <input type="hidden"
										name="product_num" value="${productVO.product_num}"> 
										<input type="hidden"
										name="kol_idnum" value="${productVO.kol_idnum}"> 
										<input
										type="hidden" name="action" value="insert"></td>
								</FORM>
								

								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/hireform/hire.do"
									style="margin-bottom: 0px;">
									<td><input type="submit" value="拒絕應徵"
										class="btn btn-block btn-danger"> <input type="hidden"
										name="product_num" value="${productVO.product_num}"> <input
										type="hidden" name="action" value="delete"></td>
								</FORM>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

	</div>


	</div>

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

</body>
</html>


<%@ include file="footer.jsp"%>
