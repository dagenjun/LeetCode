package xc;

/**
 * @description:
 * @author: YCKJ2932
 * @create: 2021-07-12
 **/
public class PrintOddAndEven {
    public static void main(String[] args) {
        Num num = new Num();
        PrintOdd odd = new PrintOdd(num);
        PrintEven even = new PrintEven(num);
        Thread a = new Thread(odd);
        Thread b = new Thread(even);
        a.start();
        b.start();
    }

    public static class Num {
        int i = 1;
        // 两个线程看， 交替执行的一个标志
        boolean flag = false;
    }

    //    打印奇数：
    public static class PrintOdd implements Runnable {
        Num num;

        public PrintOdd(Num num) {
            this.num = num;

        }

        @Override
        public void run() {
            while (num.i <= 100) {
                synchronized (num) {
                    if (num.flag) {
                        try {
                            num.wait();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("奇数----" + num.i);
                        num.i++;
                        num.flag = true;
                        num.notify();
                    }

                }
            }
        }
    }

    //        打印偶数：
    public static class PrintEven implements Runnable {

        Num num;

        public PrintEven(Num num) {
            this.num = num;

        }

        @Override
        public void run() {
            while (num.i <= 100) {
                synchronized (num) {// 必须要用同意吧锁对象，这个对象是num
                    if (!num.flag) {
                        try {
                            num.wait();// wait()函数必须和锁死同一个
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("偶数----" + num.i);
                        num.i++;
                        num.flag = false;
                        num.notify();
                    }

                }
            }
        }

    }
}
