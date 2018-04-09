package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args){
        Person zhangsan = new Student("张三");

        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        stuProxy.giveMoney();

        Dog alasijia = new Dog();

        InvocationHandler petHandler = new StuInvocationHandler<Pet>(alasijia);

        Pet petProxy = (Pet) Proxy.newProxyInstance(Pet.class.getClassLoader() , new Class<?>[]{Pet.class} , petHandler);

        petProxy.bark("wangwangwang");
    }
}
