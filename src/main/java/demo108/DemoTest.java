package demo108;

class Member{}

/**
 * ClassLoader
 * @Author: fansy
 * @Time: 2018/12/17 12:28
 * @Email: fansy1990@foxmail.com
 */
public class DemoTest {
    public static void main(String[] args) {
        Class<?> cls = Member.class ;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
