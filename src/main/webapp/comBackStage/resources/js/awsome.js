$(function () {

    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＴＡＢＬＥ,ＳＯＲＴ區======================================================================================================

    //全部選取的ＣｈｅｃｋＢｏｘ
    $("input.checkbox-master").on("click", function () {
        $("input.item").prop("checked", $(this).prop("checked"));
    })
 
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＭＡＩＬＩＮＢＯＸ區======================================================================================================
    $('#summernote').summernote({
        placeholder: '請輸入文字......',
        tabsize: 2,
        height: 200,
        shortcuts: false,

        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert', ['link']],
            ['Misc', ['fullscreen']]
        ]
    });

    $(".cln-send").on("click", function () {
        $('#summernote').summernote('reset');
        $('.send-to').val('');
        $('.send-subject').val('');
    });

    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＳＵＭＭＥＲＮＯＴＥ區======================================================================================================
    let p_num = 0;
    $('.prg-btn').on("click", function () {
        p_num = p_num + 25;
        let barMax = '500px';
        if ($('.progress-bar').css("width") != barMax) {
            $('.progress-bar').css("width", p_num + "%");
            if (p_num == 25) {
                $('div.one').find('div.text-box').css('color', '#E0E0E0');

                $('div.two').addClass('active');
            }
            if (p_num == 50) {
                $('div.two').find('div.text-box').css('color', '#E0E0E0');
                $('div.three').addClass('active');
            }
            if (p_num == 75) {
                $('div.three').find('div.text-box').css('color', '#E0E0E0');
                $('div.four').addClass('active');
            }
            if (p_num == 100) {
                $('div.four').find('div.text-box').css('color', '#E0E0E0');
                $('div.five').addClass('active');
            }
        } else {
            $('.text-box').css('color', '');
            $('.progress-bar').css("width", "0%");
            $('div.two').removeClass('active');
            $('div.three').removeClass('active');
            $('div.four').removeClass('active');
            $('div.five').removeClass('active');
            p_num = 0;
        }
    })
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＦＯＲＭＰＲＯＧＲＥＳＳ區======================================================================================================
    $(".sendOK").on("click", function () {
        //獲得內容
        let msg_content = $('#summernote').summernote('code');
        $(".email_content").val(msg_content);
        //清空summernote
    })
    //=↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＭＥＳＳＥＮＧ區======================================================================================================
    $(".trashCanBtn").on("click", function () {
        let pk;
        let array = $(this).closest(".card-body").find(".checkdelete");
        $.each(array,function(index,val) {
            if($(this).prop("checked")){
                // console.log($(this).closest("tr").find(".email_num").val());//找出有打勾的信件PK
                pk = $(this).closest("tr").find(".email_num").val();
                $(".trashCanForm").append(`<input type="hidden" name="deletePk" value="${pk}"></input>`);
            }
        })
    })
    $(".trashCanBtn").on('click',function(){
        Swal.fire({
            title: '至垃圾桶',
            text: "確定要將信件移至垃圾桶?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then((result) => {
            if (result.isConfirmed) {
                setTimeout(function () {
                    $(".trashCanForm").submit();
                }, 400);
            }
        })
     })

    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑至垃圾桶傳送PK至後端+sweetAlert======================================================================================================
    $(".deleteBtn").on("click", function () {
        let pk;
        let array = $(this).closest(".card-body").find(".checkdelete");
        $.each(array,function(index,val) {
            if($(this).prop("checked")){
                // console.log($(this).closest("tr").find(".email_num").val());//找出有打勾的信件PK
                pk = $(this).closest("tr").find(".email_num").val();
                $(".deleteForm").append(`<input type="hidden" name="deletePk" value="${pk}"></input>`);
            }
        })
    })
    $(".deleteBtn").on('click',function(){
        Swal.fire({
            title: '永久刪除信件',
            text: "確定要將信件永久刪除?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then((result) => {
            if (result.isConfirmed) {
                setTimeout(function () {
                    $(".deleteForm").submit();
                }, 400);
            }
        })
     })

    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑刪除信件傳送PK至後端+sweetAlert======================================================================================================
    
    
    $(".rollBackBtn").on("click", function () {
        let pk;
        let type;
        let array = $(this).closest(".card-body").find(".checkdelete");
        $.each(array,function(index,val) {
            if($(this).prop("checked")){
                // console.log($(this).closest("tr").find(".email_num").val());//找出有打勾的信件PK
                pk = $(this).closest("tr").find(".email_num").val();
                type = $(this).closest("tr").find(".sender").val();

                $(".rollBackForm").append(`<input type="hidden" name="rollBackPk" value="${pk}"></input>`);
                $(".rollBackForm").append(`<input type="hidden" name="rollBackType" value="${type}"></input>`);
                console.log("pk="+pk);
                console.log("type="+type);
            }
        })
    })
    $(".rollBackBtn").on('click',function(){
        Swal.fire({
            title: '復原刪除',
            text: "確定要復原刪除?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then((result) => {
            if (result.isConfirmed) {
                setTimeout(function () {
                    $(".rollBackForm").submit();
                }, 400);
            }
        })
    })
   
    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑信件取消刪除傳送PK至後端+sweetAlert======================================================================================================
   
    $(".sendOK").on('click',function(){
         let sendTo= $(".send-to").val();
         let sendSubject= $(".send-subject").val();
         let sendContent= $('#summernote').summernote('code');
        if(sendTo!="" && sendSubject!="" && sendContent !="<p><br></p>"){
            Swal.fire({
                icon: 'success',
                title: '信件已寄出',
                showConfirmButton: false,
                timer: 1000
              })
            setTimeout(function () {
                $(".sendForm").submit();
            }, 1300);
        }else{
            $(".sendForm").submit();
        }
     })
    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑寄信的Button觸發======================================================================================================
    $(".draftBtn").on('click',function(){
        let sendTo= $(".send-to").val();
        let sendSubject= $(".send-subject").val();
        let drafContent= $('#summernote').summernote('code');
        if(drafContent =="<p><br></p>"){
            Swal.fire({
                icon: 'error',
                title: '錯誤!',
                text: '無法加入空白草稿',
                showConfirmButton: false
              })
        }else{
            Swal.fire({
                icon: 'success',
                title: '已存入草稿夾!',
                showConfirmButton: false,
                timer: 1000
            })
            $(".draftForm").append(`<input type="hidden" name="draftTO" value="${sendTo}"></input>`);
            $(".draftForm").append(`<input type="hidden" name="draftTitle" value="${sendSubject}"></input>`);
            $(".email_draftContent").val(drafContent);
            $(".draftForm").append(`<input type="hidden" name="action" value="draft"></input>`);
            setTimeout(function () {
                $(".draftForm").submit();
            }, 800);
        }

    })
    
    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑+draft的Button觸發======================================================================================================

});

	 	$("#p_file").on("change", function(e){         
	     // 寫在這
	     var picBox = document.getElementsByClassName("picBox")[0];
	    picBox.innerHTML = ""; // 清空
	    
	    // 跑每個使用者選的檔案，留意 i 的部份
	    for (let i = 0; i < this.files.length; i++) {
	       let reader = new FileReader(); // 用來讀取檔案
	       reader.readAsDataURL(this.files[i]); // 讀取檔案
	       reader.addEventListener("load", function () {
	         $('.picBox').append(`<img src="${reader.result}" alt="" style="height: 300px; width: 298px;display:inline-block">`)

	       });
	     } 


	   });
          // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑新增商品預覽圖======================================================================================================

       $(".editBg").css("cursor", "pointer");
       $(".editBg").on("mousemove",function(){
            $(".editBg").css("background","rgba(255,255,255,0.3)");
       });
       $(".editBg").on("mouseout",function(){
        $(".editBg").css("background","rgba(255,255,255,0.7)");
       })
       $(".editBg").on("mousedown",function(){
        $(".editBg").css("background","rgba(255,255,255,0)");
       })
       $(".editBg").on("mouseup",function(){
        $(".editBg").css("background","rgba(255,255,255,0.7)");
       })
       $(".editBg").on("click",function(){
        $("div.overlay").fadeIn();


       })

       $("button.btn_modal_close").on("click", function(){
        $("div.overlay").fadeOut();
       });
   // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑編輯商品預覽圖按鈕======================================================================================================

   for(let i = 1; i<=5; i++){
       let btn = ".ueb"+i;
       let file  = ".updateFile"+i;

       $(btn).css("cursor", "pointer");
       $(btn).on("mousemove",function(){
            $(btn).css("background","rgba(255,255,255,0.3)");
       });
       $(btn).on("mouseout",function(){
        $(btn).css("background","rgba(255,255,255,0.7)");
       })
       $(btn).on("mousedown",function(){
        $(btn).css("background","rgba(255,255,255,0)");
       })
       $(btn).on("mouseup",function(){
        $(btn).css("background","rgba(255,255,255,0.7)");
       })
       $(btn).on("click",function(){
          $(file).click();
       })

       let box  = ".boxBg"+i


       $(file).on("change", function(e){
           $(box).css("background","");
            let reader = new FileReader();
            reader.readAsDataURL(this.files[0])
            reader.addEventListener("load", function(){
                $(box).css("background",`url(${reader.result})no-repeat`).css("background-size","145px");
            })
       })
    }


    $(".updateImgOK").on("click",function(){
        Swal.fire({
            icon: 'success',
            title: '編輯成功！',
            showConfirmButton: false,
            timer: 1000
          })
        setTimeout(function () {
            $("div.overlay").fadeOut();
        }, 1100);
    })

   // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑燈箱內修改圖片======================================================================================================
   

   for(let i = 1; i<=5; i++){
    let file  = ".updateFile"+i;
    let value  = "updatePc"+i;
    let productNum = $(".product_num").val();
    $(file).on("change", function(e){
      
      console.log($(file).closest(".updatePcGo"));
      $(file).closest(".updatePcGo").append(`
      <input type="hidden" name="action" value=${value}>
      <input type="hidden" name="product_num" value=${productNum}>
      `);
      Swal.fire({
        icon: 'success',
        title: '編輯成功！',
        showConfirmButton: false,
        timer: 1000
      })
    setTimeout(function () {
        $(file).closest(".updatePcGo").submit();
    }, 1100);




    })
 }



   // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑燈箱更新改圖片======================================================================================================
  $(".checkOK").on("click",function(){
    Swal.fire({
        title: '確定送出?',
        text: "確認對方內容正確?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                icon: 'success',
                title: '送出成功！',
                showConfirmButton: false,
                timer: 1000
              })
            setTimeout(function () {
                $(".checkOKForm").submit();
            }, 1100);
        }
    })
  });
   // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑交易流程→確定審核成功?======================================================================================================
  
  
  
   $(".rateBtn").on("click",function(){
    Swal.fire({
        icon: 'success',
        title: '送出成功！',
        showConfirmButton: false,
        timer: 1000
    })
    setTimeout(function () {
        $(".rateForm").submit();
    }, 1100);
  });
   // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑交易流程→確定送出評價?======================================================================================================