package o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import o2o.dto.ImageHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

public class ImageUtil {
    /**
     * 创建图片缩略图
     * @param imageHolder 文件操作类
     * @param targetAddr  图片存放路径
     * @return
     */
    public static String generateThumbnail(ImageHolder imageHolder, String targetAddr) {

        //String extension = FileUtil.getFileExtension(imageHolder.getFileName());

        String realFileName = UUID.randomUUID() + imageHolder.getFileName();

        FileUtil.makeDirPath(targetAddr);

        String relativeFileAddr = targetAddr + realFileName;

        File file = new File(relativeFileAddr);
        try {
            Thumbnails.of(imageHolder.getImgInputStream()).size(400,600).outputQuality(0.8f).
                    toFile(file);
        } catch (Exception e) {
            throw new RuntimeException("创建图片地址失败");
        }
        return relativeFileAddr;
    }


    public static void main(String[] args) throws FileNotFoundException {
//        String s = "E:\\image\\";
//
//        ImageHolder imageHolder = new ImageHolder();
//        imageHolder.setImgInputStream(new FileInputStream(new File("C:\\Users\\asus-pc\\Desktop\\p站\\62628015_p0.jpg")));
//        imageHolder.setFileName("62628015_p0.jpg");
//        System.out.println(generateThumbnail(imageHolder,s));
    }
}
