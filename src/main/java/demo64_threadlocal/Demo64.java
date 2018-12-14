package demo64_threadlocal;

class Message{
    public String getInfo() {
        return info;
    }

    private String info;
    public Message(String info){
        this.info = info;
    }
}
class Utils{
    private static Message message;

    public static Message getMessage() {
        return message;
    }

    public static void setMessage(Message message) {
        Utils.message = message;
    }
}
class UseMessage{

    public String print(){
        return Utils.getMessage().getInfo();
    }
}

/**
 * ThreadLocal 每个线程独享自己的内容；
 * @Author: fansy
 * @Time: 2018/12/14 12:44
 * @Email: fansy1990@foxmail.com
 */
public class Demo64 {
    public static void main(String[] args) {
        new Thread(() -> {
           Message message = new Message("A");
           Utils.setMessage(message);
            System.out.println(Thread.currentThread().getName()+"->" + new UseMessage().print());
        },"线程A").start();
        new Thread(() -> {
            Message message = new Message("B");
            Utils.setMessage(message);
            System.out.println(Thread.currentThread().getName()+"->" + new UseMessage().print());
        },"线程B").start();
    }
}
