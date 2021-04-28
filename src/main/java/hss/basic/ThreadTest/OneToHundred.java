package hss.basic.ThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HSS
 * @Date: 2021/4/25 11:40
 * @Description:
 */
public class OneToHundred {

    public static volatile int flag = 0;

    public static void main(String[] args) {
//        synchronized实现，公共资源加锁
//        Task1 task1 = new Task1();
//        new Thread(task1, "A").start();
//        new Thread(task1, "B").start();
//        long startTime = System.currentTimeMillis();
//        //非公共资源，通过控制flag的值，使得线程循环打印
//        Task2 task2 = new Task2();
//        Task3 task3 = new Task3();
//        new Thread(task2).start();
//        new Thread(task3).start();
//        while(true){
//            if(task3.i==100){
//                System.out.println(System.currentTimeMillis()-startTime);
//                System.out.println("wofaocoacoacoao");
//                break;
//            }
//
//        }
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoader.getSystemClassLoader());
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //线程池实现
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Task1 task1 = new Task1(countDownLatch);
        for (int i = 0; i < 2; i++) {
            executorService.execute(task1);
        }
        //正在执行的线程不停止，执行完成之后线程池不可加入新任务。
        executorService.shutdown();
        try {
            System.out.println("主线程开始等待");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待完成开始执行了");
//      测试线程池关闭之后，会抛出rejectExecutionException
//        Task1 task2 = new Task1();
//        for (int i = 0; i < 2; i++) {
//            executorService.execute(task2);
//        }
    }
}

class Task1 implements Runnable {
    private Integer i = 0;
    private CountDownLatch countDownLatch;

    public Task1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        while (i <= 99) {
            synchronized (this) {
                i += 1;
                System.out.println(Thread.currentThread().getName() + i);
                notify();
                try {
                    if (i < 100) {
                        wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        countDownLatch.countDown();
    }
}


class Task2 implements Runnable {
    int i = -1;

    @Override
    public void run() {

        while (i <= 98) {
            //不能加到while中去，会提前结束循环，条件单独拿出来
            if (OneToHundred.flag == 0) {
                i += 2;
                System.out.println("a:" + i);
                OneToHundred.flag = 1;
            }

        }
    }
}

class Task3 implements Runnable {
    int i = 0;

    @Override
    public void run() {

        while (i <= 98) {
            //不能加到while中去，会提前结束循环，条件单独拿出来
            if (OneToHundred.flag == 1) {
                i += 2;
                System.out.println("b:" + i);
                OneToHundred.flag = 0;
            }

        }
    }
}






