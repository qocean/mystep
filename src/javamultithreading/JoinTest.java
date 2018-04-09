package javamultithreading;

public class JoinTest {
    public static void main(String[] args){
        Thread t = new Thread(new ThreadImp());
        t.start();
        System.out.println(Thread.currentThread().getName());
        try{
            t.join(10000);
            System.out.println(Thread.currentThread().getName());
            if(t.isAlive())
                System.out.println("t has not finished");
            else
                System.out.println("t has finished");

            System.out.println("joinFinish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadImp implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Begin ThreadImpl");
            System.out.println( "T   "   +  Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("End ThreadImpl");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
