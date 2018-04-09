package toutiao2018;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findWay(1,1,1,n));
    }

    public static int findWay(int m , int s , int depth , int n){
        if( s > n) return Integer.MAX_VALUE;
        if( s == n) return depth-1;
        else{
            return Math.min( findWay(s,2*s,depth+1 , n) , findWay(m,s+m,depth+1 , n));
        }
    }
}
