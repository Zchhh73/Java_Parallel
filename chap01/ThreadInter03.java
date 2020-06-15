package chap01;

/**
 * 子线程等待特定条件的到来。使用interrupt强制sleep()抛出异常
 * 使线程从阻塞恢复到激活状态。
 */
public class ThreadInter03 {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });
        //启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获得中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获得当前线程（主线程）中断标志并重置
        System.out.println("isInterrupted:" + threadOne.interrupted());
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获得子线程中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("main is over");
    }
}
