package qihu360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for(int i=0 ; i<T ; i++){
            int n = sc.nextInt();
            for(int j =0 ; j<n ; j++) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();

                result[i] += (Math.abs(x2-x1+1) * Math.abs(y2-y1+1));
            }
        }
        for(int temp  : result)
            System.out.println(temp);
    }
}
