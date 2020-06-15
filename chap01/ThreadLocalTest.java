package chap01;

public class ThreadLocalTest {

    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }

    //创建ThreadLocal对象
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after: "+ localVariable.get());
            }
        });


        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after: "+localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
