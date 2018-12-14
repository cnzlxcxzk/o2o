package o2o.dto;

import java.io.InputStream;

/**
 * 关于文件操作封装的类
 */
public class ImageHolder {
    //文件输入流
    private InputStream imgInputStream;
    //文件名
    private String fileName;

    public InputStream getImgInputStream() {
        return imgInputStream;
    }

    public void setImgInputStream(InputStream imgInputStream) {
        this.imgInputStream = imgInputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageHolder(InputStream imgInputStream, String fileName) {
        this.imgInputStream = imgInputStream;
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
