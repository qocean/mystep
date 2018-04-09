package javamultithreading;

import java.util.ArrayList;

class Produce {

    public Object object;
    public ArrayList<Integer> list;//用list存放生产之后的数据，最大容量为1

    public Produce(Object object,ArrayList<Integer> list ){
        this.object = object;
        this.list = list;
    }

    public void produce() {

        synchronized (object) {
                     /*只有list为空时才会去进行生产操作*/
            try {
                while(!list.isEmpty()){
                    System.out.println("生产者"+Thread.currentThread().getName()+" waiting");
                    object.wait();
                }
                int value = 9999;
                list.add(value);
                System.out.println("生产者"+Thread.currentThread().getName()+" Runnable");
                object.notifyAll();//然后去唤醒因object调用wait方法处于阻塞状态的线程
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class Consumer {

    public Object object;
    public ArrayList<Integer> list;//用list存放生产之后的数据，最大容量为1

    public Consumer(Object object,ArrayList<Integer> list ){
        this.object = object;
        this.list = list;
    }

    public void consmer() {

        synchronized (object) {
            try {
                            /*只有list不为空时才会去进行消费操作*/
                while(list.isEmpty()){
                    System.out.println("消费者"+Thread.currentThread().getName()+" waiting");
                    object.wait();
                }
                list.clear();
                System.out.println("消费者"+Thread.currentThread().getName()+" Runnable");
                object.notifyAll();//然后去唤醒因object调用wait方法处于阻塞状态的线程

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class ProduceThread extends Thread {
    private Produce p;
    public ProduceThread(Produce p){
        this.p = p;
    }
    @Override
    public void run() {
        while (true) {
            p.produce();
        }
    }
}


class ConsumeThread extends Thread {
    private Consumer c;
    public ConsumeThread(Consumer c){
        this.c = c;
    }
    @Override
    public void run() {
        while (true) {
            c.consmer();
        }
    }
}

public class Main {

    public static void main(String[] args) {


        Object object = new Object();
        ArrayList<Integer> list = new ArrayList<Integer>();

        Produce p = new Produce(object, list);
        Consumer c = new Consumer(object, list);

        ProduceThread[] pt = new ProduceThread[2];
        ConsumeThread[] ct = new ConsumeThread[2];

        for(int i=0;i<2;i++){
            pt[i] = new ProduceThread(p);
            pt[i].setName("生产者 "+(i+1));
            ct[i] = new ConsumeThread(c);
            ct[i].setName("消费者"+(i+1));
            pt[i].start();
            ct[i].start();
        }
    }

    outerClass c = new outerClass();
    outerClass.staticInnerClass c1 = new outerClass.staticInnerClass();
    outerClass.memberInnerClass c2   = c.new memberInnerClass();
}

class outerClass{
    static class staticInnerClass{

    }

    class memberInnerClass{

    }
}
