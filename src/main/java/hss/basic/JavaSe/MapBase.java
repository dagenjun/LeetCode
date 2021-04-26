package hss.basic.JavaSe;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HSS
 * @Date: 2021/4/22 10:13
 * @Description:
 */
public class MapBase {
    public synchronized  int test(){
        return 1;
    }

    public static void main(String[] args) {
        new ReentrantLock();
        new ConcurrentHashMap<>();
        new HashMap<>();
    }
}
