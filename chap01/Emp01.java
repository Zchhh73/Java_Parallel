package chap01;

public class Emp01 {
    private static volatile Object A = new Object();
    private static volatile Object B = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (A) {
                        System.out.println("threadA get resourceA lock");

                        synchronized (B) {
                            System.out.println("threadA get resourceB lock");
                            System.out.println("threadA released resourceA lock");
                            A.wait();
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    synchronized (A){
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try to get resourceB lock");
                        synchronized (B){
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            A.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("over");
    }
}
