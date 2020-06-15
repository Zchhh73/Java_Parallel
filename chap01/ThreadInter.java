package chap01;

/**
 * 子线程检查当前线程中断标志控制是否退出循环。
 */
public class ThreadInter {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() +" hello");
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子线程执行完
        thread.join();
        System.out.println("main over");
    }
}
