<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
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
							<h1>會員資料修改(網紅)</h1>
							<p></p>
							<form METHOD="post" ACTION="<%=request.getContextPath()%>/kolmeb/KolMeb.do">

								<div class="row mb-3">
									<label for="K_password" class="col-md-2 col-form-label">網紅密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="K_password" name="kol_password" value="${kolMebVO.kol_password}" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_password_confirm" class="col-md-2 col-form-label">確認密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="K_password_confirm" name="kol_password" onkeyup="KC_validate()" value="${kolMebVO.kol_password}" required>
										<p id="K_tips"></p>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_membername" class="col-md-2 col-form-label">網紅名稱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_membername" name="kol_name" value="${kolMebVO.kol_name}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_memberid" class="col-md-2 col-form-label">網紅身分證:&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_memberid" name="kol_id" value="${kolMebVO.kol_id}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_membertel" class="col-md-2 col-form-label">網紅市話:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="K_membertel" name="kol_phone" value="${kolMebVO.kol_phone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_cellphone" class="col-md-2 col-form-label">網紅手機:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="K_cellphone" name="kol_cellphone" value="${kolMebVO.kol_cellphone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_bank" class="col-md-2 col-form-label">網紅銀行代碼:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_bank" name="kol_bankcode" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${kolMebVO.kol_bankcode}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_banknumber" class="col-md-2 col-form-label">網紅銀行帳戶:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_banknumber" name="kol_bankaccount" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${kolMebVO.kol_bankaccount}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_email" class="col-md-2 col-form-label">網紅信箱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="email" class="form-control" id="K_email" name="kol_email" value="${kolMebVO.kol_email}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_gender" class="col-md-2 col-form-label">網紅性別:&emsp;&emsp;</label>
									<div class="col-md-10" style="text-align: left;">
										<input type="radio" id="K_gender" name="kol_gender" value="male">男性
										<input type="radio" id="K_gender" name="kol_gender" value="female">女性
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_birthday" class="col-md-2 col-form-label">網紅生日:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="K_birthday" name="kol_birthday" value="${kolMebVO.kol_birthday}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_location" class="col-md-2 col-form-label">網紅地區:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_location" name="kol_location" value="${kolMebVO.kol_location}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_height" class="col-md-2 col-form-label">網紅身高:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_height" name="kol_height" value="${kolMebVO.kol_height}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_weight" class="col-md-2 col-form-label">網紅體重:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_weight" name="kol_weight" value="${kolMebVO.kol_weight}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_style" class="col-md-2 col-form-label">網紅個人風格:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_style" name="kol_style" value="${kolMebVO.kol_style}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_experience" class="col-md-2 col-form-label">網紅過往經歷:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_experience" name="kol_experience" value="${kolMebVO.kol_experience}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_address" class="col-md-2 col-form-label">網紅地址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_address" name="kol_address" value="${kolMebVO.kol_address}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_website" class="col-md-2 col-form-label">網紅網址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_website" name="kol_website" value="${kolMebVO.kol_website}" required>
									</div>
								</div>

								<div class="row">
								
									<div class="col-md-4">
									<div class="float-right">
										<a class="btn btn-primary" id="V_member_save" href="/mether/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp">編輯照片</a>
									</div>
									</div>
									<div class="col-md-4">
									<div class="float-middle">
										<button type="submit" class="btn btn-primary" id="K_member_save">儲存資料</button>
									</div>
									</div>
									<div class="col-md-4">
									<div class="float-left">
										<a class="btn btn-primary" id="V_member_save" href="/mether/kolBackStage/kolmeb/kolAboutJsp.jsp">會員預覽</a>
									</div>
									</div>
								</div>
								
								<input type="hidden" name="action" value="update">
								<input type="hidden" name="kol_idnum" value="<%=kolMebVO.getKol_idnum()%>">

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		</section>
	</div>



		
		
<%@ include file="footer.jsp"%>
		