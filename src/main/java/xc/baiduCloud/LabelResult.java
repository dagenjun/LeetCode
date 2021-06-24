package xc.baiduCloud;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: YCKJ2932
 * @date: 2020/11/13 10:39
 */
@Data
public class LabelResult extends LabelBaseResult implements Serializable {
    private int[] error;
    /**
     * 是否变更字段
     */
    private int isChange;
}
