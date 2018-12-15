package demo34_thread_priority;

class Demo34Thread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i =0;i< 3; i++){
            System.out.println(Thread.currentThread().getName()+ "-" +i);
        }
    }
}

/**
 * 设置线程优先级
 * @author fanzhe
 * @email fansy1990@foxmail.com
 * @date 2018/12/9 AM9:10.
 */
public class DemoClass {

    public static void main(String args[]){
        Demo34Thread dt1 = new Demo34Thread();
//        Demo34Thread dt2 = new Demo34Thread();
//        Demo34Thread dt3 = new Demo34Thread();

        Thread t1 = new Thread(dt1,"A");
        Thread t2 = new Thread(dt1,"B");
        Thread t3 = new Thread(dt1,"C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

}
