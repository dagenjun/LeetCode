//package xc.baiduCloud;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
///**
// * @description:
// * @author: YCKJ2932
// * @create: 2021-03-29
// **/
//public class VatInvoice {
//    private static final Logger log = LoggerFactory.getLogger(VatInvoice.class);
//    /**
//     * 重要提示代码中所需工具类
//     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
//     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
//     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
//     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
//     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
//     * 下载
//     */
//
//    private static final List<String> fileNames = new ArrayList<String>();
//
//    public static void vatInvoice() {
//        // 请求url
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice";
//        List<BigDecimal> similarList = new ArrayList<>();
//        try {
//            // 本地文件路径
//            String filePath = "C:\\Users\\YCKJ2932\\Desktop\\50张验证";
//            deepCollectFile(new File(filePath));
//            for (String file : fileNames) {
//                byte[] imgData = FileUtil.readFileByBytes(filePath + "\\" + file);
//                String imgStr = Base64Util.encode(imgData);
//                String imgParam = URLEncoder.encode(imgStr, "UTF-8");
//
//                String param = "image=" + imgParam;
//
//                // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//                String accessToken = "24.060a68cf96a769d6b2af00c81999a025.2592000.1619581316.282335-23890123";
//
//                String result = HttpUtil.post(url, accessToken, param);
////                String result = "{\"words_result\":{\"AmountInWords\":\"贰万贰仟肆佰零捌圆叁角贰分\",\"InvoiceNumConfirm\":\"07521993\",\"CommodityPrice\":[],\"NoteDrawer\":\"郭利英\",\"SellerAddress\":\"广州市越秀区东风西路191号十七楼01-02室62871843\",\"CommodityNum\":[],\"SellerRegisterNum\":\"91440104712421962C\",\"MachineCode\":\"\",\"Remarks\":\"+506-10单元10月管理费09月电费10月管理费09月电费\",\"SellerBank\":\"平安银行广州流花支行11000866702701\",\"CommodityTaxRate\":[{\"row\":\"1\",\"word\":\"6%\"},{\"row\":\"2\",\"word\":\"16%\"},{\"row\":\"3\",\"word\":\"6%\"},{\"row\":\"4\",\"word\":\"16%\"}],\"TotalTax\":\"1484.32\",\"InvoiceCodeConfirm\":\"4400182130\",\"CheckCode\":\"\",\"InvoiceCode\":\"4400182130\",\"InvoiceDate\":\"2018年10月08日\",\"PurchaserRegisterNum\":\"913100007416029816\",\"InvoiceTypeOrg\":\"广东增值税专用发票\",\"Password\":\"55*-*4215</8856-174>2/72113/<*1*->58522502<*130+*>318<71<+717*>2*0+//5952*375>6><2093>*<1*-8494++592**92234<\",\"Agent\":\"否\",\"AmountInFiguers\":\"22408.32\",\"PurchaserBank\":\"工商银行虹桥机场支行1001229409004692281\",\"Checker\":\"吴培婵\",\"City\":\"\",\"TotalAmount\":\"20924.00\",\"CommodityAmount\":[{\"row\":\"1\",\"word\":\"12807.74\"},{\"row\":\"2\",\"word\":\"1524.34\"},{\"row\":\"3\",\"word\":\"5827.36\"},{\"row\":\"4\",\"word\":\"764.56\"}],\"PurchaserName\":\"中国东方航空股份有限公司\",\"CommodityType\":[],\"Province\":\"\",\"InvoiceType\":\"专用发票\",\"SheetNum\":\"第三联\",\"PurchaserAddress\":\"上海市浦东新区国际机场大道66号021-22335542\",\"CommodityTax\":[{\"row\":\"1\",\"word\":\"768.46\"},{\"row\":\"2\",\"word\":\"243.89\"},{\"row\":\"3\",\"word\":\"349.64\"},{\"row\":\"4\",\"word\":\"122.33\"}],\"CommodityUnit\":[],\"Payee\":\"郭利英\",\"CommodityName\":[{\"row\":\"1\",\"word\":\"*企业管理服务*管理及综合收费\"},{\"row\":\"2\",\"word\":\"*生活服务*电费\"},{\"row\":\"3\",\"word\":\"*企业管理服务*管理及综合收费\"},{\"row\":\"4\",\"word\":\"*生活服务*电费\"}],\"SellerName\":\"广州市金卫物业管理有限公司\",\"InvoiceNum\":\"07521993\"},\"log_id\":1376749517495336960,\"words_result_num\":38}";
//                JSONObject resultObject = JSON.parseObject(result).getJSONObject("words_result");
//
//                //映射百度云OCR处理结果
//                HashMap<String, String> map = new HashMap<>(100);
//                map.put("NoteType", resultObject.get("InvoiceTypeOrg").toString());
//                map.put("NoteCode", resultObject.get("InvoiceCode").toString());
//                map.put("NoteNo", resultObject.get("InvoiceNum").toString());
//                map.put("NoteDate", resultObject.get("InvoiceDate").toString());
//                map.put("BuyerName", resultObject.get("PurchaserName").toString());
//                map.put("BuyerTaxID", resultObject.get("PurchaserRegisterNum").toString());
//                map.put("BuyerAddrTel", resultObject.get("PurchaserAddress").toString());
//                map.put("BuyerBank", resultObject.get("PurchaserBank").toString());
//                map.put("SellerName", resultObject.get("SellerName").toString());
//                map.put("SellerTaxID", resultObject.get("SellerRegisterNum").toString());
//                map.put("SellerAddrTel", resultObject.get("SellerAddress").toString());
//                map.put("SellerBank", resultObject.get("SellerBank").toString());
//                map.put("TotalAmount", resultObject.get("TotalAmount").toString());
//                map.put("TotalTax", resultObject.get("TotalTax").toString());
//                map.put("PriceTaxUp", resultObject.get("AmountInWords").toString());
//                map.put("PriceTaxLow", resultObject.get("AmountInFiguers").toString());
//                map.put("Payee", resultObject.get("Payee").toString());
//                map.put("Checker", resultObject.get("Checker").toString());
//                map.put("Drawer", resultObject.get("NoteDrawer").toString());
//                map.put("Password", resultObject.get("Password").toString());
//
//                //映射云图标注结果，对比基线
//                String fileTxtPath = replaceFilePathSuffixWithTxt(filePath + "\\" + file);
//                AiLabelDTO aiLabelDTO = JSON.parseObject(readFile(fileTxtPath), AiLabelDTO.class);
//                List<LabelResult> labelResultList = aiLabelDTO.getAiLabel();
//                //关键字段key
//                Set<String> keys = map.keySet();
//                int totalKey = 0;
//                int errorNum = 0;
//                StringBuilder pwd = new StringBuilder();
//                for (LabelResult labelResult : labelResultList) {
//                    String name = labelResult.getName();
//                    String value = labelResult.getValue();
//
//                    if ("Password".equals(name)) {
//                        pwd.append(value);
//                    } else if (keys.contains(name)) {
//                        //基线value不为空，当前标签有效，可以用于文本相似度比较，与云图比较标准一致
//                        if (!StringUtils.isEmpty(value)) {
//                            totalKey++;
//                            //当前标签识别结果不一致，识别错误+1
//                            if (!value.equals(map.get(name))) {
//                                System.out.println(name + "——（百度识别）：" + map.get(name) + "   （云图标注）：" + value);
//                                errorNum++;
//                            }
//                        }
//                    }
//                }
//                String pwdStr = pwd.toString();
//                if (!StringUtils.isEmpty(pwdStr)) {
//                    totalKey++;
//                    if (!pwdStr.equals(map.get("Password"))) {
//                        System.out.println("Password——（百度识别）：" + map.get("Password") + "   （云图标注）：" + pwdStr);
//                        errorNum++;
//                    }
//                }
//                BigDecimal similar = BigDecimal.valueOf(((totalKey - errorNum) * 1.0d) / totalKey).setScale(4, BigDecimal.ROUND_HALF_UP);
//                similarList.add(similar);
//                System.out.println(file + ":" + similar);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("average：" + similarList.stream().mapToDouble(BigDecimal::doubleValue).average());
//
//    }
//
//    public static List<String> deepCollectFile(File file) {
//        String fileName = file.getName();
//        if (fileName.substring(fileName.lastIndexOf('.') + 1).equalsIgnoreCase("jpg")) {
//            fileNames.add(fileName);
//        } else {
//            if (file.isDirectory()) {
//                File[] childrenFiles = file.listFiles();
//                if (childrenFiles != null && childrenFiles.length > 0) {
//                    for (File child : childrenFiles) {
//                        deepCollectFile(child);
//                    }
//                }
//            }
//        }
//        return fileNames;
//    }
//
//    public static String readFile(String path) {
//        String data = null;
//        File file = new File(path);
//        if (file.exists()) {
//            String code = getFileEncode(path);
//            if (!"UTF8".equals(code) && !"UTF-8".equals(code)) {
//                code = "GBK";
//            }
//            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), code)) {
//                char[] buffer = new char[1024];
//                StringBuilder sb = new StringBuilder();
//                int length;
//                while ((length = isr.read(buffer, 0, 1024)) != -1) {
//                    sb.append(buffer, 0, length);
//                }
//                data = sb.toString();
//            } catch (Exception e) {
//                log.error(e.getMessage(), e);
//            }
//        }
//        return data;
//    }
//
//    public static String getFileEncode(String path) {
//        String charset = "asci";
//        byte[] first3Bytes = new byte[3];
//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
//            boolean checked = false;
//            bis.mark(0);
//            int read = bis.read(first3Bytes, 0, 3);
//            if (read == -1) {
//                return charset;
//            }
//            if ((first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) ||
//                    (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF)) {
//                charset = "Unicode";//UTF-16LE
//                checked = true;
//            } else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB
//                    && first3Bytes[2] == (byte) 0xBF) {
//                charset = "UTF8";
//                checked = true;
//            }
//            bis.reset();
//            if (!checked) {
//                while ((read = bis.read()) != -1) {
//                    if (read >= 0xF0) {
//                        break;
//                    }
//                    if (0x80 <= read && read <= 0xBF) { //单独出现BF以下的，也算是GBK
//                        break;
//                    }
//                    if (0xC0 <= read && read <= 0xDF) {
//                        read = bis.read();
//                        if (!(0x80 <= read && read <= 0xBF)) {
//                            break;
//                        }
//                        // else 双字节 (0xC0 - 0xDF) (0x80 - 0xBF),也可能在GB编码内
//
//                    } else if (0xE0 <= read) {
//                        read = bis.read();
//                        if (0x80 <= read && read <= 0xBF) {
//                            read = bis.read();
//                            if (0x80 <= read && read <= 0xBF) {
//                                charset = "UTF-8";
//                                break;
//                            } else {
//                                break;
//                            }
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//        return charset;
//    }
//
//    private static String replaceFilePathSuffixWithTxt(String filePath) {
//        if (StringUtils.isBlank(filePath)) {
//            return "";
//        }
//
//        String replace = filePath.replace(".jpg", "");
//        replace = replace.replace(".JPG", "");
//        replace = replace.replace(".png", "");
//        replace = replace.replace(".PNG", "");
//        replace = replace.replace(".jpeg", "");
//        replace = replace.replace(".JPEG", "");
//
//        return replace + ".txt";
//    }
//
//    public static void main(String[] args) {
//        vatInvoice();
//    }
//}
