package JaveBaseTest;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java AQS测试demo
 * */
@Log
public class AqsTest {

//        static int anInt = 0;
//        public static void main(String[] args){
//        Runnable runnable = () -> {
//            synchronized (Main.class){
//                while (anInt <= 1000) {
//                    System.out.println("线程：" + Thread.currentThread().getName() + "计算：" + anInt++);
//                }
//            }
//        };
//        for (int i = 0; i < 3; i++) {
//            new Thread(runnable).start();
//        }
//    }


    static AtomicInteger count = new AtomicInteger(0);
    public static void acs(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count.get() <= 1000) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "计算：" + count.getAndIncrement());
                }
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }

    public static void aqs(){
        ReentrantLock lock = new ReentrantLock(true);
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }

            @Override
            protected int tryAcquireShared(int arg) {
                return super.tryAcquireShared(arg);
            }

            @Override
            protected boolean tryReleaseShared(int arg) {
                return super.tryReleaseShared(arg);
            }

            @Override
            protected boolean isHeldExclusively() {
                return super.isHeldExclusively();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }



}
