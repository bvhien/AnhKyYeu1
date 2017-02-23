package Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;

public class Constants {

    public static String fileName = "http://localhost:8086/AnhKyYeu/webresources";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static String ConvertUTF8(String str) {
        byte[] bytesData = str.getBytes();
        String decodedDataUsingUTF8 = null;
        try {
            decodedDataUsingUTF8 = new String(bytesData, "UTF-8");
            System.out.println("asdsad:" + decodedDataUsingUTF8);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            Logger.getLogger(Constants.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decodedDataUsingUTF8;

    }

    public static String getInstanceMd5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Constants.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(str.getBytes());
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static String UploadImage(String imageDataBytes) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ImageName = timestamp.getTime() + "";
        if (imageDataBytes != null && !imageDataBytes.equals("")) {
            imageDataBytes = imageDataBytes.substring(imageDataBytes.indexOf(",") + 1);
            BufferedImage image = null;
            byte[] imageByte;
            try {
                BASE64Decoder decoder = new BASE64Decoder();
                imageByte = decoder.decodeBuffer(imageDataBytes);
                ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
                image = ImageIO.read(bis);
//                bis.close();

                // write the image to a file
                File outputfile = new File("../../../web/Guest-Image/" + ImageName + ".png");
                System.out.println("outputfile:"+outputfile.getAbsolutePath());
                ImageIO.write(image, "png", outputfile);
                System.out.println("=========upload anh thanh cong===========");
            } catch (Exception e) {
                ImageName = null;
                e.printStackTrace();
            }

        }
        return ImageName + ".png";
    }

    @SuppressWarnings({"UnusedAssignment", "null"})
    public static boolean DeleteImage(String ImageName) {
        boolean ck =true;
        try {
            File fileimage = new File("web/Guest-Image/"+ImageName);
            String UrlAbsolute = fileimage.getAbsolutePath();
            UrlAbsolute = UrlAbsolute.replace("lib\\apache-tomcat-8.0.39\\bin\\", "");
            File fileimage1 = new File(UrlAbsolute);
            if (fileimage1 != null || fileimage1.exists()) {
                if (fileimage1.exists()) {
                    fileimage1.delete();
                    if (!fileimage1.exists()) {
                        System.out.println("Xoa thanh cong");
                       ck = true;
                    }else{
                        System.out.println("Xoa khong thanh cong");
                        ck = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ck = false;
        }
        return ck;
    }

    public static void main(String[] args) throws IOException {
        String a = "1487178268820.png";
        DeleteImage(a);
    }
}
