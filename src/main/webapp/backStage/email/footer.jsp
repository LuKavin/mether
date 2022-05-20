<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<div class="col-md-2">
		<!--==側邊功能列表==-->
		<div class="card">
			<div class="card-header">
				<div class="row justify-content-center">
					<a href="<%=request.getContextPath()%>/backStage/email/sendEmail.jsp" class="btn btn-warning"
						style="padding: 5px 30px;"> <i class="fa fa-paper-plane-o" aria-hidden="true"> 寄信</i>
					</a>
				</div>
			</div>
			<ul class="nav nav-pills flex-column">
				<li class="nav-item active"><a href="<%=request.getContextPath() %>/backStage/email/Email.jsp" class="nav-link">
						<i class="fas fa-inbox"></i> 收件夾
					</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath() %>/backStage/email/draft.jsp" class="nav-link"> <i class="far fa-file-alt"></i> 草稿夾
					</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath() %>/backStage/email/trashCan.jsp" class="nav-link"> <i
							class="far fa-trash-alt"></i> 垃圾桶
					</a></li>
			</ul>
		</div>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
	</div>
	</section>
	</div>
	<!--這個div結尾是 email, sendEmail, letter的第22行<div.row結尾> -->
	<!-- ============================================================================================================================================= -->

	<!-- jquery -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
		integrity="sha512-BHDCWLtdp0XpAFccP2NifCbJfYoYhsRSZOUM3KnAxy2b/Ay3Bn91frud+3A95brA4wDWV3yEOZrJqgV8aZRXUQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
		integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<!-- bootstrap -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>
	<!-- admin-lte -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
		integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="<%=request.getContextPath()%>/backStage/resources/js/adminlte.js"></script>
	<!-- Table sort -->
	<script src="<%=request.getContextPath()%>/backStage/resources/js/sort.js"></script>
	<!-- Summernote -->
	<script src="<%=request.getContextPath()%>/backStage/resources/summernote/summernote-bs4.min.js"></script>
	<!-- sweet alert2 -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<!-- CJN Js -->
	<script src="<%=request.getContextPath()%>/backStage/resources/js/awsome.js"></script>
	
	</body>

	</html>