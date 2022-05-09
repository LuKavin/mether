$(function () {

    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＴＡＢＬＥ,ＳＯＲＴ區======================================================================================================

    //全部選取的ＣｈｅｃｋＢｏｘ
    $("input.checkbox-master").on("click", function () {
        $("input.item").prop("checked", $(this).prop("checked"));
    })
 
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＭＡＩＬＩＮＢＯＸ區======================================================================================================
    $('#summernote').summernote({
        placeholder: '可拖曳圖片至此...',
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
            ['Misc', ['fullscreen']]
        ]
    });

    $(".cln-send").on("click", function () {
        console.log('123');
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
        console.log("123");
        //獲得內容
        let msg_content = $('#summernote').summernote('code');
        $(".email_content").val(msg_content);
        //清空summernote
        $('#summernote').summernote('reset');



    })

    //=↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＭＥＳＳＥＮＧ區======================================================================================================
    let pk;
    $(".trashcan").on("click", function () {
        let array = $(this).closest(".card-body").find(".checkdelete");
        $.each(array,function(index,val) {
            if($(this).prop("checked")){
                // console.log($(this).closest("tr").find(".email_num").val());//找出有打勾的信件PK
                pk = $(this).closest("tr").find(".email_num").val();
                console.log(pk);
                $(".trashform").append(`<input type="hidden" name="deletePk" value="${pk}"></input>`);
            }
        })
    })









    // ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑信箱刪除======================================================================================================































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
