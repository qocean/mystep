public class MyResult implements Runnable{

    int i = 1;

    @Override
    public void run() {
        synchronized (this){
            while(i<=10){
                notify();
                System.out.println(i++);
                if(i>10) return;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]){
//        MyResult myResult = new MyResult();
//        Thread thread1 = new Thread(myResult);
//        Thread thread2 = new Thread(myResult);
//        thread1.start();
//        thread2.start();
        System.out.println("".length());
    }
}
