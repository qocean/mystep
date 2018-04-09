import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long money = in.nextLong();
        long max = (long)Math.log(money);
        long value1 = (long) Math.pow(2,max);
        long value2 = money - value1;

        long count = value1^value2;
    }
}
