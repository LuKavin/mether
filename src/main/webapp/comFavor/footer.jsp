<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- ============================================================================================================================================= -->

	<!-- jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
		integrity="sha512-BHDCWLtdp0XpAFccP2NifCbJfYoYhsRSZOUM3KnAxy2b/Ay3Bn91frud+3A95brA4wDWV3yEOZrJqgV8aZRXUQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
		integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<!-- bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>
	<!-- admin-lte -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
		integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="<%=request.getContextPath()%>/comBackStage/resources/js/adminlte.js"></script>
	<!-- CJN Js -->
	<script src="<%=request.getContextPath()%>/comBackStage/resources/js/awsome.js"></script>
	<!-- Table sort -->
	<script src="<%=request.getContextPath()%>/comBackStage/resources/js/sort.js"></script>
		<script>
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {

							document
									.querySelector("#p_file")
									.addEventListener(
											"change",
											function(e) {
												if (this.files.length > 0) {
													preview_img(this.files[0]);
												} else {
													document
															.querySelector("#preview .text").innerText = "預覽圖";
												}

											})

							//函式：接收一個file(圖片)參數，將接收的(圖片)顯示在預覽圖上
							function preview_img(file) {
								var reader = new FileReader();
								reader.readAsDataURL(file)
								reader
										.addEventListener(
												"load",
												function() {
													let db64 = 'data:image/jpg;base64';
													let rr = reader.result;
													var post = `<img src="\${rr}" alt="載入錯誤" class = "preview_img">`;
													document
															.querySelector("#preview .text").innerText = "";//先清空
													if (document
															.querySelector("#preview img") != null) {
														document.querySelector(
																"#preview>img")
																.remove();
													}
													document
															.querySelector(
																	"#preview")
															.insertAdjacentHTML(
																	"beforeend",
																	post);
													console
															.log(document
																	.querySelector("#preview img"));
												})

							}

						})
	</script>
	
	<script>

	// Favorite Button - Heart
	$('.favme').click(function() {
		$(this).toggleClass('active');
	});

	/* when a user clicks, toggle the 'is-animating' class */
	$(".favme").on('click touchstart', function(){
	  $(this).toggleClass('is_animating');
	});

	/*when the animation is over, remove the class*/
	$(".favme").on('animationend', function(){
	  $(this).toggleClass('is_animating');
	});
	
	</script>

</body>
</html>