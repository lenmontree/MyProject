package JaveBaseTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    volatile String s = "";

    public final void test(String[] args){
        synchronized (new ReentrantLockTest.AAAAAA()){
            ReentrantLock reentrantLock = new ReentrantLock(true);
            reentrantLock.lock();
            reentrantLock.unlock();
            AtomicInteger atomicInteger = new AtomicInteger();
        }

    }

     class AAAAAA{
         public AAAAAA() {
         }
     }

}
