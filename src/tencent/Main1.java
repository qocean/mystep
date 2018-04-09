package tencent;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger bi = BigInteger.valueOf(n);
        BigInteger b2= bi.multiply(BigInteger.valueOf(m));
        BigInteger b3 = b2.divide(BigInteger.valueOf(2));
        System.out.println(b3.toString());
    }
}
