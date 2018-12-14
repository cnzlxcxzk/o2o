package o2o.util;

import o2o.entity.Shop;

import java.io.File;

public class FileUtil {

    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    private static String se = System.getProperty("file.separator");
    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 递归创建多级目录
     * @param targetAddr
     */
    public static void makeDirPath(String targetAddr) {
        File file = new File(targetAddr);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 返回项目文件根路径
     * @return
     */
    public static String getBasePath() {

        String osName = System.getProperty("os.name");
        String basePath = null;
        if (osName.toLowerCase().contains("win"))
            basePath = "E:/o2o1/";
        if (osName.toLowerCase().contains("lin"))
            basePath = "/home/o2o1/";
        return basePath.replace("/",se);

    }

    /**
     * 获取店铺缩略图的路径
     * @param shop
     * @return
     */
    public static String getShopImgPath(Shop shop) {
        String path = "upload/shop/" + shop.getShopId() +"/";
        return path.replace("/",se);
    }
}
