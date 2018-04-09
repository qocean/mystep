package meitu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n>0 && n%10 != 0){
            n -= 6;
            count++;
        }
        if(n<0) {
            System.out.println(-1);
            return;
        }
        count += n/10;
        System.out.println(count);
    }

    public static int findAnswer(int n , int count){
        if(n==0) return count;
        else{
            return findAnswer(findAnswer(n-10 , count+1) , findAnswer(n-10 , count+1));
        }
    }
}
