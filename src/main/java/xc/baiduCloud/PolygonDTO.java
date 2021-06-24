package xc.baiduCloud;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author：vic
 * @date： 2020/9/29 17:06
 * @desc:
 */
@Data
public class PolygonDTO implements Serializable {
    /**
     * 图形所属关联组
     */
    protected int groupId;

    /**
     * 围成图形的点
     */
    protected List<PointDTO> nodeList;

    /**
     * 图形边的数量
     * @return 图形边的数量
     */
    protected int edgeCount(){
        return nodeList.size();
    }

    /**
     * 图形是否是合法的
     * @return true：合法，false：不合法
     */
    protected boolean valid(){
        return true;
    }
}
