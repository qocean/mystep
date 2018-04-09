package dynamicproxy;

public class Dog implements Pet {
    @Override
    public void bark(String barking) {
        System.out.println(this.getClass().getName() + "  is barking: " + barking );
    }
}
