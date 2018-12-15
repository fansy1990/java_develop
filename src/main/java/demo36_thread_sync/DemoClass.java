package demo36_thread_sync;

class Demo36Thread implements Runnable {
    private int ticket = 1000;

    @Override
    public void run() {

        for (int i = 0; i < 2000; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            ", ticket =" + this.ticket--);
                }
            }
        }
    }
}

class Demo36Thread2 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            this.sale();
        }
    }

    public synchronized  void sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    ", ticket =" + this.ticket--);
        }
    }
}

/**
 * 卖票问题第一次实现
 *
 * @author fanzhe
 * @email fansy1990@foxmail.com
 * @date 2018/12/9 AM9:10.
 */
public class DemoClass {

    public static void main(String args[]) {
//        Demo36Thread dt1 = new Demo36Thread();
        Demo36Thread2 dt1 = new Demo36Thread2();


        Thread t1 = new Thread(dt1, "卖票1");
        Thread t2 = new Thread(dt1, "卖票2");
        Thread t3 = new Thread(dt1, "卖票3");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

}
