package o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request ) {

        String verifyCodeExcepted = (String) request.getSession().getAttribute(
                Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpRequestUtil.getString(request,"verifycode");
        if (verifyCodeActual.equals(verifyCodeExcepted))
            return true;
        else
            return false;
    }
}
