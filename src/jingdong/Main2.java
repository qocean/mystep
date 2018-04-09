package jingdong;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0 ; i<n ; i++){
            long k = sc.nextInt();
            long m = k;
            if(k%2 == 1) System.out.println("No");
            else{
                while(k%2 == 0)
                    k /= 2;
                System.out.println(k + " " +m/k );
            }
        }
    }
}
