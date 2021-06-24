package xc.baiduCloud;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author：vic
 * @date： 2020/9/29 17:15
 * @desc:  分类属性
 */
@Data
public class Classification<K,V> implements Serializable {
    protected K      key;
    protected V      val;
    protected List<Classification<K,V>> children;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Classification<?, ?> that = (Classification<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val, children);
    }
}

