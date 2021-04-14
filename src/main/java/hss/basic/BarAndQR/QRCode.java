package hss.basic.BarAndQR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HSS
 */
class QRCode {
    public static void main(String[] args){

        //readQrCode(new File("3.png"));
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("3.png");
        try {
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//            hints.put(DecodeHintType.PURE_BARCODE,Boolean.TRUE);
//            hints.put(DecodeHintType.TRY_HARDER,Boolean.TRUE);
            Result result = formatReader.decode(binaryBitmap, hints);

            System.out.println("解析结果： " + result.toString());
            System.out.println("二维码的格式类型：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容： " + result.getText() );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readQrCode(File file) {
        MultiFormatReader reader = new MultiFormatReader();
        try{


            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //L级：约可纠错7%的数据码字,M级：约可纠错15%的数据码字,Q级：约可纠错25%的数据码字,H级：约可纠错30%的数据码字
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
            hints.put(EncodeHintType.MARGIN, 2);
            MultiFormatReader formatReader = new MultiFormatReader();
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("二维码解析结果：" + result.toString());
            System.out.println("二维码的格式：" + result.getBarcodeFormat());
            System.out.println("二维码的文本内容：" + result.getText());
        }catch (Exception ex){
            System.out.println("异常");
        }
    }

}
