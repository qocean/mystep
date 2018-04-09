package javajdk8;

interface LambdaTest {

    abstract void print();
}

interface LambdaTest2 {

    abstract void print(String a);
}

interface DefalutTest {

    static int a =5;
    default void defaultMethod(){
        System.out.println("DefalutTest defalut 方法");
    }

    int sub(int a,int b);

    static void staticMethod() {
        System.out.println("DefalutTest static 方法");
    }
}

public class Main {

    public static void main(String[] args) {
        //匿名内部类--java8之前的实现方式
        DefalutTest dt = new DefalutTest(){
            @Override
            public int sub(int a, int b) {
                // TODO Auto-generated method stub
                return a-b;
            }
        };

        //lambda表达式--实现方式1
        DefalutTest dt2 =(a,b)->{
            return a-b;
        };
        System.out.println(dt2.sub(2, 1));

        //lambda表达式--实现方式2，省略花括号
        DefalutTest dt3 =(a,b)->a-b;
        System.out.println(dt3.sub(5, 6));

        //测试final
        int c = 5;
        DefalutTest dt4 =(a,b)->a-c;
        System.out.println(dt4.sub(5, 6));

        //无参方法，并且执行语句只有1条
        LambdaTest lt = ()-> System.out.println("测试无参");
        lt.print();
        //只有一个参数方法
        LambdaTest2 lt1 = s-> System.out.println(s);
        lt1.print("有一个参数");
    }
}
