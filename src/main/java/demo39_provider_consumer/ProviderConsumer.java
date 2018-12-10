package demo39_provider_consumer;

/**
 * 生产者消费者基本模型 ：解决数据不完整问题:
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
    private String name ;

    public synchronized void set(String info,String name) throws InterruptedException {
        this.info = info;
        Thread.sleep(100);
        this.name = name ;
    }

    public synchronized  void get() throws InterruptedException {
        Thread.sleep(50);
        System.out.println(this.name+"="+this.info);
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
