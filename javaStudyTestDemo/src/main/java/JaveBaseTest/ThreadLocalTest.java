package JaveBaseTest;

import javafx.concurrent.Worker;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Handler;

@SuppressWarnings("all")
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] args){
//        threadLocal.set(Thread.currentThread().getName());
//        for (int i = 0; i < 8; i++) {
//            new Thread(() -> {
//                threadLocal.set(Thread.currentThread().getName());
//                System.out.println(Thread.currentThread().getName() + "计算：" + threadLocal.get());
//            }).start();
//        }
//        System.out.println(Thread.currentThread().getName() + "计算：" + threadLocal.get());
    threadPoolExecutorDemo();
    }

    public static void threadPoolExecutorDemo() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                3,
                5000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2)
        );

        for(int i=0;i<6;i++){
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(10000);
                    System.out.println("线程：" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }



}
