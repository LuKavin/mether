<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp" %>
<%
ProductService productService = new ProductService();
// CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");//讀取登入者的資料
List<ProductVO> list = productService.getComAllProduct(companyMebVO.getCom_idnum());
pageContext.setAttribute("list", list);
%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<!-- Main content -->

			<section class="content">



				<div class="content-header">
					<div class="container-fluid">
						<div class="row mb-2">
							<div class="col-sm-6">
								<h1 class="m-0 aaa">訂單列表</h1>
							</div>
							<!-- /.col -->
							<div class="col-sm-3">
								<!-- 錯誤列表 -->
								<c:if test="${not empty errorMsgs}">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</c:if>
							</div>
							<div class="col-sm-3">
							</div>
						</div>
					</div>
				</div>
				
				      <section class="content">
        <div class="container-fluid">
          <div class="col-md-12">
            <div class="card card-info">
              <div class="card-body p-0">
                <table class="table table-hover sortable">
                  <thead>
                    <tr>
                      <th>訂單編號
                      </th>
                      <th>商品編號
                      </th>
                      <th>交易狀態
                      </th>
                      <th>日期
                      </th>
                      <!-- <td></td> -->
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>800441</td>
                      <td>評價中</td>
                      <td>2022/10/05</td>
                      <td class="text-right py-0 align-middle">
                          <div href="#" class="btn btn-info"><i class="fas fa-eye">_詳細資料</i></div>

                      </td>
                    </tr>

                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>


      </section>
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			</section>
		</div>
	</div>
	
<%@ include file="footer.jsp" %>
	
	
	
	
	
	
	
