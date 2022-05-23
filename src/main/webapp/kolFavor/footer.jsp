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

	// Favorite Button - Heart
	$('.favme').click(function() {
		$(this).toggleClass('active');
	});

	/* when a user clicks, toggle the 'is-animating' class */
	/* $(".favme").on('click touchstart', function(){
	  $(this).toggleClass('is_animating');
	}); */

	/*when the animation is over, remove the class*/
	/* $(".favme").on('animationend', function(){
	  $(this).toggleClass('is_animating');
	}); */
	</script>
	
	 <!-- <script>
             //在網頁加載後，對id=doAjaxBtn的Button設定click的function
            $(document).ready(function(){
               $(".fav-btn").click(function(){
            	   console.log('123');
 	
                    $.ajax({
                        type:"POST",                    //指定http參數傳輸格式為POST
                        url: "${pageContext.request.contextPath}/getComMebInfo.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                        data:{status: "1" },
                        dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                        contentType: 'application/json; charset=UTF-8',
                        // success : function(response){
                        //     //在id=ajaxResponse的fieldset中顯示Ajax的回傳值
                        // 	$("#ajaxResponse1").html("廠商名稱:"+response.com_name+"</br>");
                        //     $("#ajaxResponse2").html("廠商編號:"+response.com_idnum+"</br>");
                        //     $("#ajaxResponse3").html("廠商信箱:"+response.com_email+"</br>");
                        //     $("#ajaxResponse4").html("廠商網站:"+response.com_website+"</br>");
                        //     $("#ajaxResponse5").html("廠商電話:"+response.com_phone+"</br>");
 
                        // },
                        error:function(xhr, ajaxOptions, thrownError){
                            alert(xhr.status+"\n"+thrownError);
                        }
                    }); 
               });
            });  
        </script> -->

</body>
</html>