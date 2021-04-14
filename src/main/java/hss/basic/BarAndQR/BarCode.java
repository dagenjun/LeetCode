package hss.basic.BarAndQR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HSS
 */
public class BarCode {
    /**
     * 根据code生成相应的一维码
     * @param file 一维码目标文件
     * @param code 一维码内容
     * @param width 图片宽度
     * @param height 图片高度
     */
    public static void generateCode(File file, String code, int width, int height){
        //定义位图矩阵BitMatrix
        BitMatrix matrix=null;
        try{
            //使用code_128格式进行表面生成100*25的条形码
            MultiFormatWriter writer = new MultiFormatWriter();
            matrix= writer.encode(code, BarcodeFormat.CODE_128,width,height,null);
            // matrix= writer.encode(code,BarcodeFormat.EAN_13,width,height,null);
        }catch (Exception ex){ex.printStackTrace();}
        //将位图矩阵BitMatrix保存为图片
        try(FileOutputStream outStream =new FileOutputStream(file)){
            ImageIO.write(MatrixToImageWriter.toBufferedImage(matrix),"png",outStream);
            outStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        //generateCode(new File("1dcode.png"),"123456789012",500,250);
        readCode(new File("7.png"));
    }

    /**
     * 解析一维码
     * @param file
     */
    private static void readCode(File file) {
        try{
            BufferedImage read = ImageIO.read(file);
            if (null==read) {
                return;
            }
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(read);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Map<DecodeHintType,Object> hints=new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET,"GBK");
            hints.put(DecodeHintType.PURE_BARCODE,Boolean.TRUE);
            hints.put(DecodeHintType.TRY_HARDER,Boolean.TRUE);

            Result decode = new MultiFormatReader().decode(bitmap, hints);
            System.out.println("条形码的内容是："+decode.getText());
        }catch (Exception ex){}
    }

}
