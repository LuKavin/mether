// $(document).ready(function () {
//     /* Open lightbox on button click */
//         $(".favbtn").click(function () {
//             console.log("111");
//             $(".backdrop")
//             .animate({ opacity: ".50" }, 300, "linear")
//             .css("display", "block");
//             $(".box").fadeIn();
//         });

//         /* Click to close lightbox */
//         $(".close, .backdrop").click(function () {
//             $(".backdrop").animate({ opacity: "0" }, 300, "linear", function () {
//             $(".backdrop").css("display", "none");
//             });
//             $(".box").fadeOut();
//         });
//     });
$(document).ready(function() {
    // DOM 載入完成之後
    //onclick打開lightbox
    $(".favbtn").on("click",function(){
        console.log("有!");
        $(".backdrop")
        .animate({ opacity: ".50"}, 300, "linear")
        .css("display", "block");
        $(".lightbox").fadeIn();
    });
    //點擊關閉lightbox
    $(".close, .backdrop").on("click", function(){
        $(".backdrop").animate({ opacity: "0" }, 300, "linear", function(){
            $(".backdrop").css("display","none");
        });
        $(".lightbox").fadeOut();
    });


});