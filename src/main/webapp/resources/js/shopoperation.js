$(function () {
    var initUrl = 'getshopinitinfo';

    getShopInitInfo();

    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if(data.success) {
                var tempHtml = '';
                var index = 0;
                $.map(data.shopcategorylist,function (item) {
                    tempHtml += '<option value="'+(index++) +'id=\"item.shopCategoryId\"'+'">'
                        + item.shopCategoryName + '</option>';
                })
                $('#shopCategory').html(tempHtml);
                tempHtml = "";
                $.map(data.arealist,function (item) {
                    tempHtml += '<option value="'+(index++) +'id=\"item.areaId\"'+'">'
                        + item.areaName + '</option>';
                })
                $('#area').html(tempHtml);

            }
        })
    }
    
})