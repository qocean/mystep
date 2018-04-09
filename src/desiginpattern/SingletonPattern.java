package desiginpattern;

public class SingletonPattern {

}

class Test{
    private Test(){}
    private static Test uniqueInstance = new Test();
    public static Test getUniqueInstance(){
        return uniqueInstance;
    }
}
