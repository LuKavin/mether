<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<%@ include file="header.jsp"%>






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
							<h1>會員資料修改(廠商)</h1>
							<p></p>
							<form METHOD="post" ACTION="<%=request.getContextPath()%>/companymeb/CompanyMeb.do">
							
								<div class="row mb-3">
									<label for="V_password" class="col-md-2 col-form-label">廠商密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password" name="com_password" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" value="${companyMebVO.com_password}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_password_confirm" class="col-md-2 col-form-label">確認密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password_confirm" name="com_password" onkeyup="VC_validate()" value="${companyMebVO.com_password}" required>
										<p id="V_tips"></p>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companyname" class="col-md-2 col-form-label">廠商名稱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companyname" name="com_name" value="${companyMebVO.com_name}"	required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_birthday" class="col-md-2 col-form-label">廠商生日:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="V_birthday" name="com_birthday" value="${companyMebVO.com_birthday}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_memberid" class="col-md-2 col-form-label">廠商身分證:&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_memberid" name="com_id" value="${companyMebVO.com_id}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_membertel" class="col-md-2 col-form-label">廠商市話:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="V_membertel" name="com_phone" value="${companyMebVO.com_phone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_cellphone" class="col-md-2 col-form-label">廠商手機:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="V_cellphone" name="com_cellphone" value="${companyMebVO.com_cellphone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_bank" class="col-md-2 col-form-label">廠商銀行代碼:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_bank" name="com_bankcode" value="${companyMebVO.com_bankcode}" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_banknumber" class="col-md-2 col-form-label">廠商銀行帳戶:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_banknumber" name="com_bankaccount" value="${companyMebVO.com_bankaccount}" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_email" class="col-md-2 col-form-label">廠商信箱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="email" class="form-control" id="V_email" name="com_email" value="${companyMebVO.com_email}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_gender" class="col-md-2 col-form-label">廠商性別:&emsp;&emsp;</label>
									<div class="col-md-10" style="text-align: left;">
										<input type="radio" id="V_gender" name="com_gender" value="male">男性
										<input type="radio" id="V_gender" name="com_gender" value="female">女性
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_taxnumber" class="col-md-2 col-form-label">統一編號:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_taxnumber" name="com_taxidnum" value="${companyMebVO.com_taxidnum}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_company_found_date"
										class="col-md-2 col-form-label">廠商成立日期: </label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="V_company_found_date" name="com_founddate" value="${companyMebVO.com_founddate}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companyaddress" class="col-md-2 col-form-label">廠商地址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companyaddress" name="com_address" value="${companyMebVO.com_address}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companywebsite" class="col-md-2 col-form-label">廠商網址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companywebsite" name="com_website" value="${companyMebVO.com_website}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_introduce" class="col-md-2 col-form-label">廠商介紹:&emsp;&emsp;</label>
									<div class="col-md-10">
									
										<textarea id="V_introduce" name="com_introduce" class="form-control"  required>${companyMebVO.com_introduce}</textarea>
										<!-- <input type="textarea" class="form-control" id="V_introduce" required> -->
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
									<div class="float-right">
										<a class="btn btn-primary" id="V_member_save" href="/mether/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp">編輯照片</a>
									</div>
									</div>
									<div class="col-md-4">
									<div class="float-middle">
										<button type="submit" class="btn btn-primary" id="V_member_save">儲存資料</button>
									</div>
									</div>
									<div class="col-md-4">
									<div class="float-left">
										<a class="btn btn-primary" id="V_member_save" href="/mether/comBackStage/companymeb/comAboutJsp.jsp">會員預覽</a>
									</div>
									</div>
								</div>
								
								<input type="hidden" name="action" value="update">
								<input type="hidden" name="com_idnum" value="<%=companyMebVO.getCom_idnum()%>">

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>


		
		
		
		
		</section>
	</div>
		
	
		
		
		
		


			<%@ include file="footer.jsp"%>

