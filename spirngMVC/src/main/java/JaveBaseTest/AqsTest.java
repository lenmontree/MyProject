package JaveBaseTest;

public class AqsTest {

    static int anInt = 0;
    public static void main(String[] args){
        Runnable runnable = () -> {
            while (anInt < 100) {
                System.out.println("线程：" + Thread.currentThread().getName() + "计算：" + anInt++);
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }
}
