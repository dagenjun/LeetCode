package hss.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author HSS
 * @Date: 2021/4/22 10:16
 * @Description:
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map1=new HashMap<>(16);
        map1.put(null,null);
        Map<Integer,String> map2=new TreeMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"线程池开始执行");
                }
            });
        }
        executorService.shutdown();
        test();
    }
    public synchronized static int test(){
        return 1;
    }
}
