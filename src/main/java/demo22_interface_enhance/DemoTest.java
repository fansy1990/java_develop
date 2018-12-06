package demo22_interface_enhance;

interface IMessage{
    public void print();

    public default void say(){
        System.out.println("say 1");
    }
}

class IMessageImpl implements IMessage{

    public void print() {
        System.out.println("hello world");
    }
}

/**
 * 接口加强
 * @Author: fansy
 * @Time: 2018/12/6 9:40
 * @Email: fansy1990@foxmail.com
 */
public class DemoTest {
    public static void main(String[] args) {
        IMessage iMessage = new IMessageImpl();
        iMessage.print();
        iMessage.say();
    }
}
