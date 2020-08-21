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
        }
    }
    if("password"==obj){
        var password=document.form.password;
        var reg=/(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{6,20}$/;
        if(password.value==""){
            document.getElementById("password_msg").innerHTML="密码不能为空";
            password.focus();
        }else if(!reg.test(password.value)){
            document.getElementById("password_msg").innerHTML="密码至少包含数字和字母的6~20位字符";
            password.focus();
        }else{
            document.getElementById("password_msg").innerHTML="";
        }
    }
    if("confirmPW"==obj){
        var confirmPW=document.form.confirmPW;
        var password=document.form.password;
        if(confirmPW.value==""){
            document.getElementById("confirmPW_msg").innerHTML="确认密码不能为空";
            confirmPW.focus();
        }else if(confirmPW.value!=password.value){
            document.getElementById("confirmPW_msg").innerHTML="密码与上次不同";
            confirmPW.focus();
        }else{
            document.getElementById("confirmPW_msg").innerHTML="";
        }
    }
    if("valiateNum"==obj){
        var reg=/^[0-9]*$/;
        var valiateNum=document.form.valiateNum.value;
        if(valiateNum==""){
            document.getElementById("valiateNum_msg").innerHTML="验证码不能为空";
            valiateNum.focus();
        }else if(!reg.test(valiateNum)){
            document.getElementById("valiateNum_msg").innerHTML="验证码必须为数字格式";
            valiateNum.focus();
        }else{
            document.getElementById("valiateNum_msg").innerHTML="";
            valiateNum.focus();
        }
    }

}