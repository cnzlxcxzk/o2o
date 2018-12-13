package o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestUtil {
    public static String getString(HttpServletRequest request, String key) {

        try {
            String result = request.getParameter(key);

            if(null != result) {
                return result.trim();
            }
            if ("".equals(result)) {
                return null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static int getInt(HttpServletRequest request, String key) {

        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Long getLong(HttpServletRequest request, String key) {

        try {
            return Long.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1l;
        }
    }
    public static Double getDouble(HttpServletRequest request, String key) {

        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }
    }
}
