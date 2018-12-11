package demo40_provider_consumer;

/**
 * 生产者消费者基本模型 ：解决数据重复问题:
 * 1. 数据不完整；
 * 2. 数据有重复；
 * @Author: fansy
 * @Time: 2018/12/10 12:34
 * @Email: fansy1990@foxmail.com
 */

class Provider implements Runnable{
    private Data data;
    public Provider(Data data){
        this.data = data;
    }
    @Override
    public void run() {
        for(int i =0;i< 20 ;i++){
            if(i %2 ==0){
                try {
                    this.data.set("A","A-info");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    this.data.set("B","B-info");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable{
    private Data data ;
    public Consumer(Data data){
        this.data = data;
    }
    @Override
    public void run() {
        for(int i = 0 ;i < 20 ;i ++){
            try {
                this.data.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Data{
    private boolean canGet = false;
    private String name ;

    public synchronized void set(String info,String name) throws InterruptedException {
        if(canGet == true){// 已经设置了，不能重复设置
            super.wait();// 等待取走
        }
        this.info = info;
        Thread.sleep(100);
        this.name = name ;
        this.canGet = true;
        super.notify();
    }

    public synchronized  void get() throws InterruptedException {
        if(canGet == false){// 还在设置值阶段，不能继续操作
            super.wait();
        }
        Thread.sleep(50);
        System.out.println(this.name+"="+this.info);
        this.canGet = false;
        super.notify();
    }

    private String info;

}

public class ProviderConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        Thread t1 = new Thread(new Provider(data));
        Thread t2 = new Thread(new Consumer(data));

        t1.start();
        t2.start();
    }
}
