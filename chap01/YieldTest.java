package chap01;

public class YieldTest implements Runnable{

    YieldTest(){
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for(int i =0;i<5;i++){
            //当i=0时让出CPU，进行下一轮调度
            if((i%5)==0){
                System.out.println(Thread.currentThread()+" yield cpu..");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+" is over");
    }


}
