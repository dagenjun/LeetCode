package hss.basic.ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author HSS
 * @Date: 2021/4/25 10:53
 * @Description:
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);


        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程开始执行");

                        Thread.sleep(1000);
                        countDownLatch.countDown();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        try{
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("主线程开始执行");

    }
}
