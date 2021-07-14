package hss.basic;


import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HSS
 * @Date: 2021/7/14 16:56
 * @Description:
 */
public class Singleton {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 1; i < 10510; i++) {

            Runnable runnable = new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    countDownLatch.await();
                    Singleton singleton1 = getSingleton();
                    System.out.println(singleton1);
                }
            };
            executorService.execute(runnable);
        }
        countDownLatch.countDown();
    }

    private Singleton() {
    }

    private volatile static Singleton singleton;

    private static Singleton getSingleton() {
        if (singleton == null) {

            synchronized (Singleton.class) {
                if(singleton==null){
                    singleton = new Singleton();
                }


            }
        }
        return singleton;
    }
}
