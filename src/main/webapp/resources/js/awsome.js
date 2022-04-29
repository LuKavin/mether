$(function () {
    
    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＴＡＢＬＥ,ＳＯＲＴ區======================================================================================================

    //全部選取的ＣｈｅｃｋＢｏｘ
    $("input.checkbox-master").on("click", function () {
        $("input.item").prop("checked", $(this).prop("checked"));
    })
    //刪除勾選信件
    $(".trashcan").on("click", function () {
        $(".item:checked").closest("tr").fadeOut(700, function () {
            $(".item:checked").closest("tr").remove();
        })
    })
    //測試用新增信件
    $(".testplus").on("click", function () {
        count = count + 1;
        let add = `<tr>
        <td>
        <div class="icheck-primary">
        <input type="checkbox" value="" id="check${count}" class="item">
        <label for="check${count}"></label>
        </div>
        </td>
      <td class="mailbox-star"><a href="#"><i class="fas fa-star text-warning"></i></a></td>
      <td class="mailbox-name"><a href="read-mail.html">Alexander Pierce</a></td>
      <td class="mailbox-subject"><b>AdminLTE 3.0 Issue</b> - Trying to find a solution to this
      problem...
      </td>
      <td class="mailbox-attachment"></td>
      <td class="mailbox-date">5 mins ago</td>
      </tr>`;
        $(".mailtable").append(add);

        //   console.log(count);
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


$(".msg-ok").on("click", function () {
    //獲得標題內容
    let msg_title = $(".msg_title").val();
    //獲得圖片內容
    let msg_content = $('#summernote').summernote('code');
    let msg_add = `
    <div class="card card-warning card-outline">
    <div class="card-header">
      <div class="row">
        <div class="container h4" style="text-align: center;background-color: rgb(234, 240, 250);">
          廠商
        </div>
      </div>
      <div class="row">
        <div class="col-sm-2 p-1">
          <h5>標題：</h5>
        </div>
        <p>${msg_title}</p>
      </div>
    </div>
    <div class="card-body">
      ${msg_content}
    </div>
  </div>`;
   //新增留言
   $(this).closest("div.msg-input").before(msg_add);
   //清空標題
   $(".msg_title").val("");
   //清空summernote
   $('#summernote').summernote('reset');









})













//=↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ＭＥＳＳＥＮＧ區======================================================================================================



















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