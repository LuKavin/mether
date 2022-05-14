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
        let sendContent= $('#summernote').summernote('code');
        if(sendContent =="<p><br></p>"){
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
            $(".draftForm").append(`<input type="hidden" name="draftContent" value="${sendContent}"></input>`);
            $(".draftForm").append(`<input type="hidden" name="action" value="draft"></input>`);
    
            setTimeout(function () {
                $(".draftForm").submit();
            }, 800);
        }

    })
    
    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑+draft的Button觸發======================================================================================================






















    //==============================ＦＵＮＣＴＩＯＮ區======================================================================================================


























    // 用css 新增手狀樣式,滑鼠移上去變小手,變小手
    // cursor:pointer;
    // 用JS使滑鼠變小手onmouseover(滑鼠越過的時候)
    // onmouseover="this.style.cursor='hand'"cursor其他取值
    //  auto :標準游標
    //  default :標準箭頭
    //  pointer, hand :手形游標
    //  wait :等待游標
    //  text :I形游標
    //  vertical-text :水平I形游標
    //  no-drop :不可拖動游標
    //  not-allowed :無效游標
    //  help :幫助游標
    //  all-scroll :三角方向標
    //  move :移動標
    //  crosshair :十字標 




});