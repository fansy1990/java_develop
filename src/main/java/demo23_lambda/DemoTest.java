package demo23_lambda;


interface IMessage{
    public void print();
}

/**
 * Lambda 表达式
 * @Author: fansy
 * @Time: 2018/12/6 9:47
 * @Email: fansy1990@foxmail.com
 */
public class DemoTest {
    public static void main(String[] args) {
        IMessage iMessage = new IMessage() {
            @Override
            public void print() {
                System.out.println("hello World");
            }
        };
        iMessage.print();
    }
}
