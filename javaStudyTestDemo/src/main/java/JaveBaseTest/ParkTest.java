package JaveBaseTest;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args){
//        parkTest();
        interruptionTest();
    }

    public static void interruptionTest(){
        /**
         * Thread.interrupted();
         * Thread.currentThread().interrupt();
         * Thread.currentThread().isInterrupted();
         * interrupt（）是给线程设置中断标志；
         * interrupted（）是检测中断并清除中断状态，interrupted（）作用于当前线程，
         * isInterrupted（）只检测中断。
         * 还有重要的一点就是
         * interrupt（）和isInterrupted（）作用于此线程，即代码中调用此方法的实例所代表的线程。
         *
         * */
        new Thread(() -> {
            try {

                System.out.println();
                System.out.println("线程中断状态1："+Thread.currentThread().isInterrupted());//输出false
                Thread.currentThread().interrupt();//当前线程中断
                System.out.println("线程中断状态2："+Thread.currentThread().isInterrupted());//输出true

                Thread.sleep(3000);//中断后执行sleep会抛出异常
                System.out.println("如果你看不到我，表示线程已经中断了");
            } catch (InterruptedException e) {
                //当前线程设置了中断之后，并不会真正中断，而实如果调用会抛出出interruptionException的方法才真正中断，
                // 然后抛出异常，同时中断标志重新置为false
                e.printStackTrace();
                System.out.println("线程中断状态3："+Thread.currentThread().isInterrupted());//输出false\
            }

        }).start();
    }

    public static void parkTest() {
        Thread parkedThread = new Thread(() -> {
            System.out.println("park test start");
//            LockSupport.park();
            Thread.currentThread().interrupt();
            System.out.println("park test end，哈哈我又开始执行了");
        });
        parkedThread.start();


//
//        UnParkRunnable unParkRunnable = new UnParkRunnable(parkedThread);
//        Thread unParkThread = new Thread(unParkRunnable);
//        unParkThread.start();

        Runnable runnable = new interruptedThread(parkedThread);
        Thread thread = new Thread(runnable);
        thread.start();

    }

    static class UnParkRunnable implements Runnable {
        private Thread thread;

        UnParkRunnable(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("unPark test start,name:" + thread.getName());
            LockSupport.unpark(thread);
            System.out.println("unPark test end,我唤醒了线程name:" + thread.getName());
        }
    }

    static class interruptedThread implements Runnable {
        private Thread thread;

        interruptedThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("interruptedThread start,name:" + thread.getName());
            try {
                thread.join();
            } catch (InterruptedException t) {
                System.out.println(Thread.currentThread().getName());
            }
            System.out.println("interruptedThread end,我唤醒了线程name:" + thread.getName());
        }
    }
}
