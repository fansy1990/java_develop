package demo23_lambda;

@FunctionalInterface  // 设置Annotation ，只能有一个函数
interface IMessage1{
    public void print();
//    public void aaa(); // 不能定义多个函数
}

/**
 * Lambda 表达式
 * @Author: fansy
 * @Time: 2018/12/6 9:47
 * @Email: fansy1990@foxmail.com
 */
public class DemoTest1 {
    public static void main(String[] args) {
        IMessage1 iMessage = () -> System.out.println("aaa");
    }
}
