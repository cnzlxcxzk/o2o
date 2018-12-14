$(function () {
    var initUrl = 'getshopinitinfo';
    var registerUrl = 'registershop';

    getShopInitInfo();

    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if(data.success) {
                var tempHtml = '';
                var index = 0;
                $.map(data.shopcategorylist,function (item) {
                    tempHtml += '<option value="' + item.shopCategoryId + '">'
                        + item.shopCategoryName + '</option>';
                })
                $('#shopCategory').html(tempHtml);
                tempHtml = "";
                $.map(data.arealist,function (item) {
                    tempHtml += '<option value="' + item.areaId +'">'
                        + item.areaName + '</option>';
                })
                $('#area').html(tempHtml);
            }
        });
        $('#submit').click(function () {
            var shop = {};
            shop.shopName = $('#shopname').val();
            shop.shopAddr = $('#address').val();
            shop.phone = $('#phone').val();
            shop.shopDesc = $('#desc').val();
            var shopCategory = {};
            shopCategory.shopCategoryId = $('#shopCategory').find('option:selected').val();
            shop.shopCategory = shopCategory;

            var area = {};
            area.areaId = $('#area').find('option:selected').val();
            shop.area = area;
            var formData = new FormData();

            var shopImg = $('#shopimg')[0].files[0];
            formData.append("shop",JSON.stringify(shop));
            formData.append("shopImg",shopImg);

            var verifycode = $('#verifycode').val();
            if(!verifycode) {
                alert("请输入验证码");
                return;
            }
            formData.append("verifycode",verifycode);
            $.ajax({
                url :registerUrl,
                type : 'POST',
                contentType:false,
                processData:false,
                cache:false,
                data : formData,
                success : function (data) {
                    if (data.success) {
                        alert("提交成功");
                    } else {
                        alert("提交失败，" + data.errmsg);
                        $('#img').click();
                    }
                }

            })
        })
    }
})