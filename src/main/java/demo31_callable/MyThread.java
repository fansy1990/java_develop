package demo31_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable实现线程，获得返回值
 * @Author: fansy
 * @Time: 2018/12/7 10:02
 * @Email: fansy1990@foxmail.com
 */
class DemoThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World";
    }
}

public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new DemoThread());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
