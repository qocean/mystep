package wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if(s.length()==0) {System.out.println("N"); return;}
        int now = 2;
        for(int i=0 ; i<n ; i++){
            char c = s.charAt(i);
            if(c == 'L')
                now = (now-1)%4;
            else{
                now = (now+1)%4;
            }
        }
        if(now == 0)    System.out.println("S");
        else if(now == 1) System.out.println("W");
        else if(now == 2) System.out.println("N");
        else System.out.println("E");
    }
}
