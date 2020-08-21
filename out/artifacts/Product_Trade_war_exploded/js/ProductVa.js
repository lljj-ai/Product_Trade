function check(obj) {
    //只能由数字组成
    var reg=/^[0-9]*$/;
    if("costPrice"==obj){
        var costPrice = document.getElementById("costPrice").value;
        if(!reg.test(costPrice)){
            document.getElementById("costPrice_msg").innerHTML="商品成本价必须为数字";
            costPrice.focus();
        }else {
            document.getElementById("costPrice_msg").innerHTML="";
            costPrice.focus();
        }
    }
    if("sellingPrice"==obj){
        var sellingPrice=document.getElementById("sellingPrice").value;
        if(!reg.test(sellingPrice)){
            document.getElementById("sellingPrice_msg").innerHTML="商品销售价必须为数字";
            costPrice.focus();
        }else{
            document.getElementById("sellingPrice_msg").innerHTML="";
            costPrice.focus();
        }
    }
}