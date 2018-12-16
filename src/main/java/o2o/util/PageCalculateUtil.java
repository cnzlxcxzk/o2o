package o2o.util;

public class PageCalculateUtil {

    public static int getRowIndex(int pageIndex,int pageSize) {
        return pageIndex <= 1?0:(pageIndex - 1) * pageSize;
    }
}
