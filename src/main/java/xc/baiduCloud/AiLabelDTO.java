package xc.baiduCloud;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: ocrplatform
 * @author: YCKJ2932
 * @create: 2020-10-21
 **/
@Data
public class AiLabelDTO implements Serializable {
    /**
     * 旋转角度
     */
    private Integer rotateAngle;
    /**
     * optional OCR标注结果
     */
    private List<LabelResult> aiLabel;
}
