/**
 * 点击改变验证码
 * @param img
 */
function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 1000);
}