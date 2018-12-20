package demo111_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface ISubject{
    void eat(String who, String what ,int howMany);
}

class RealSubject implements ISubject{
    @Override
    public void eat(String who, String what ,int howMany) {
        System.out.println(who + " eat "+howMany+" " + what );
    }
}

class ProxySubject implements InvocationHandler{

    private Object target;// 真实主题

    /**
     * 绑定真实主题，返回代理主题
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 进行动态调用，同时返回调用结果
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(method);
        System.out.println(Arrays.toString(args));
        return null;
    }
}

/**
 * 动态代理
 * @Author: fansy
 * @Time: 2018/12/18 12:44
 * @Email: fansy1990@foxmail.com
 */
public class TestDemo {
    public static void main(String[] args) {
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("张三","apple" , 3);
    }
}
