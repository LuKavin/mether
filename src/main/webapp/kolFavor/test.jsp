<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AjaxTest-新增工作類型</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
         <script>
             //在網頁加載後，對id=doAjaxBtn的Button設定click的function
            $(document).ready(function(){
               $("#doAjaxBtn").click(function(){
 	
                   $.ajax({
                        type:"POST",                    //指定http參數傳輸格式為POST
                        url: "${pageContext.request.contextPath}/getComMebInfo.do",        //請求目標的url，可在url內加上GET參數，如 www.xxxx.com?xx=yy&xxx=yyy
                        dataType: "json",               //目標url處理完後回傳的值之type，此列為一個JSON Object
                        contentType: 'application/json; charset=UTF-8',
                        success : function(response){
                            //在id=ajaxResponse的fieldset中顯示Ajax的回傳值
                        	$("#ajaxResponse1").html("廠商名稱:"+response.com_name+"</br>");
                            $("#ajaxResponse2").html("廠商編號:"+response.com_idnum+"</br>");
                            $("#ajaxResponse3").html("廠商信箱:"+response.com_email+"</br>");
                            $("#ajaxResponse4").html("廠商網站:"+response.com_website+"</br>");
                            $("#ajaxResponse5").html("廠商電話:"+response.com_phone+"</br>");
 
                        },
                        error:function(xhr, ajaxOptions, thrownError){
                            alert(xhr.status+"\n"+thrownError);
                        }
                    });
               });
            });  
        </script>
    </head>
    <body>
    
    <input type="text" name="" placeholder="" class="inputjobtype">
    <input type="hidden" name="action" value="insert">
    <input type="button" value="新增" class="submitInsert">
    
    
    <button id="doAjaxBtn">新增最愛</button>
        <span id="ajaxResponse1"></span>
        <span id="ajaxResponse2"></span>
        <span id="ajaxResponse3"></span>
        <span id="ajaxResponse4"></span>
        <span id="ajaxResponse5"></span>
    </body>  
    
    
    
    
    
</html>