// 密碼及確認密碼驗證是否輸入相同(Vendor註冊)

function V_validate(){
    var pw1 = document.getElementById("V_password").value;
      var pw2 = document.getElementById("V_password_confirm").value;
    if(pw1 == pw2) {
       document.getElementById("V_tips").innerHTML="<font color='green'></font>";
       document.getElementById("V_member_submit").disabled = false;
      }
      else {
       document.getElementById("V_tips").innerHTML="<font color='red'>兩次密碼不相同</font>";
       document.getElementById("V_member_submit").disabled = true;
      }
}

// 密碼及確認密碼驗證是否輸入相同(KOL註冊)

function K_validate(){
  var pw1 = document.getElementById("K_password").value;
    var pw2 = document.getElementById("K_password_confirm").value;
  if(pw1 == pw2) {
     document.getElementById("K_tips").innerHTML="<font color='green'></font>";
     document.getElementById("K_member_submit").disabled = false;
    }
    else {
     document.getElementById("K_tips").innerHTML="<font color='red'>兩次密碼不相同</font>";
     document.getElementById("K_member_submit").disabled = true;
    }
}

// 密碼及確認密碼驗證是否輸入相同(Vendor修改會員)

function VC_validate(){
  var pw1 = document.getElementById("V_password").value;
    var pw2 = document.getElementById("V_password_confirm").value;
  if(pw1 == pw2) {
     document.getElementById("V_tips").innerHTML="<font color='green'></font>";
     document.getElementById("V_member_save").disabled = false;
    }
    else {
     document.getElementById("V_tips").innerHTML="<font color='red'>兩次密碼不相同</font>";
     document.getElementById("V_member_save").disabled = true;
    }
}

// 密碼及確認密碼驗證是否輸入相同(KOL修改會員)

function KC_validate(){
  var pw1 = document.getElementById("K_password").value;
    var pw2 = document.getElementById("K_password_confirm").value;
  if(pw1 == pw2) {
     document.getElementById("K_tips").innerHTML="<font color='green'></font>";
     document.getElementById("K_member_save").disabled = false;
    }
    else {
     document.getElementById("K_tips").innerHTML="<font color='red'>兩次密碼不相同</font>";
     document.getElementById("K_member_save").disabled = true;
    }
}

// 廠商上傳圖片(廠商修改會員)

var preview_el = document.getElementById("preview");
var p_file_el = document.getElementById("p_file");

var preview_img = function(file){
  var reader = new FileReader(); // 用來讀取檔案
  reader.readAsDataURL(file); // 讀取檔案
  reader.addEventListener("load", function () {
    //console.log(reader.result);
    /*
    let img_node = document.createElement("img"); // <img>
    img_node.setAttribute("src", reader.result); // <img src="base64">
    img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
    preview_el.innerHTML = '';
    preview_el.append(img_node);
    */

  let img_str = '<img src="' + reader.result + '" class="preview_img">';
  preview_el.innerHTML = img_str;
  });
};

//p_file_el.addEventListener("change", function(e){
//  if(this.files.length > 0){
//    preview_img(this.files[0]);
//  }else{
//    preview_el.innerHTML = '<span class="text">預覽圖</span>';
//  }
//});

// 廠商上傳圖片(所有會員照片>會員照片新增)

//function loadImageFile(event) {
//	var image = document.getElementById('image');
//	image.src = URL.createObjectURL(event.target.files[0]);
//};
