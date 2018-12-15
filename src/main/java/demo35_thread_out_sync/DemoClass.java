package demo35_thread_out_sync;

class Demo35Thread implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {

        for(int i =0;i< 20; i++){
            if(ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        ", ticket =" + ticket--);
            }
        }
    }
}

/**
 * 卖票问题第一次实现
 * @author fanzhe
 * @email fansy1990@foxmail.com
 * @date 2018/12/9 AM9:10.
 */
public class DemoClass {

    public static void main(String args[]){
        Demo35Thread dt1 = new Demo35Thread();


        Thread t1 = new Thread(dt1,"卖票1");
        Thread t2 = new Thread(dt1,"卖票2");
        Thread t3 = new Thread(dt1,"卖票3");
        t1.start();
        t2.start();
        t3.start();
    }

}
