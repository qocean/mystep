package lianjia;

import java.util.HashSet;
import java.util.Scanner;

public class Main0408 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n ; i++){
            int k = sc.nextInt();
            for(int j=0; j<k ; j++){
                set.add(sc.nextInt());
            }
        }
        System.out.println(set.size());
    }
}
