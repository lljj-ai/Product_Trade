let number=0;
function checkFiled(obj){
    if("phone"==obj){
        var phone=document.form.phone;
        var reg=/^((0\d{2,3}-\d{7,8})|(1[3456789]\d{9}))$/;
        if(phone.value==""){
            document.getElementById("phone_msg").innerHTML="电话号码不能为空";
            phone.focus();
        }else if(!reg.test(phone.value)){
            document.getElementById("phone_msg").innerHTML="电话号码格式不正确";
            phone.focus();
        }else{
            document.getElementById("phone_msg").innerHTML=""; 
            number++;
        }
    }
    if("password"==obj){
        var password=document.form.password;
        var reg=/(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{6,20}$/;
        if(password.value==""){
            document.getElementById("password_msg").innerHTML="密码不能为空";
            password.focus();
        }else if(!reg.test(password.value)){
            document.getElementById("password_msg").innerHTML="密码格式不正确";
            password.focus();
        }else{
            number++;
            document.getElementById("password_msg").innerHTML="";
        }
    }
}