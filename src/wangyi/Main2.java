package wangyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k==0) { System.out.println(n*n); return; }
        long result = 0;
        //当x<y的时候
        result += ( (n-k)*(n-k+1)/2 );
        //当x>y的时候
        for(int y=2 ; y<=n ; y++){
            for(int yushu = k ; yushu<y; yushu++){
                result += (n-yushu)/y;
            }
        }

        System.out.println(result);
    }
}
