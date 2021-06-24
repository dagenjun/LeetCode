package xc.baiduCloud;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author：vic
 * @date： 2020/9/29 17:13
 * @desc:
 */
@Data
public class LabelBaseResult implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    /**
     * 属性名称
     */
    private String  name;
    /**
     * 属性值
     */
    private String  value;
    /**
     * 多边形
     */
    private PolygonDTO polygon;
    /**
     * 分类信息
     */
    private Classification<String, Object> classification;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
       LabelBaseResult that = (LabelBaseResult) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(polygon, that.polygon) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, polygon, classification);
    }
}
