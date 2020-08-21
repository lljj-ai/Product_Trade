function check(obj){
    //只能由中文组成
    var reg= /^[\u4e00-\u9fa5],{0,}$/;
    //只能由字母组成
    var reg1=/^[a-zA-Z]+$/;
    //只能由数字组成
    var reg2=/^[0-9]*$/;
    if("age"==obj) {
        var age = document.getElementById("age").value;
        if ((!reg2.test(age) )|| age <0||age==0 || age > 100) {
            document.getElementById("age_msg").innerHTML = "年龄只能是0~100的数字";
            age.focus();
        } else {
            document.getElementById("age_msg").innerHTML = "";
            age.focus();
        }
    }
    if("sex"==obj){
        var sex=document.getElementById("sex").value;
        if(!reg.test(sex)){
            document.getElementById("sex_msg").innerHTML="性别只能由汉字组成";
            sex.focus();
        }else {
            document.getElementById("sex_msg").innerHTML="";
            sex.focus();
        }
    }

    if("tel"==obj){
        var tel=document.getElementById("tel").value;
        if(!reg2.test(tel)){
            document.getElementById("tel_msg").innerHTML="此字段只能为数字";
            tel.focus();
        }else {
            document.getElementById("tel_msg").innerHTML="";
            tel.focus();
        }
    }

}