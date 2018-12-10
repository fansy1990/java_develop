package demo38_provider_consumer;

/**
 * 生产者消费者基本模型:
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
                this.data.setName("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.data.setInfo("A-info");
            }else{
                this.data.setName("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.data.setInfo("B-info");
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.data.getInfo()+"=" + this.data.getName());
        }
    }
}

class Data{
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
