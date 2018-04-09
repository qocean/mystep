package tencent;

import java.util.Scanner;

public class Main2_shijie {

    public static long cal(int n, int r){
        long result=1;
        for(int i=1;i<=r;i++){
            result = result%1000000007*(n-i+1)/i%1000000007;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int A = scanner.nextInt();
        int x = scanner.nextInt();
        int B = scanner.nextInt();
        int y = scanner.nextInt();

        long num=0;
        for(int i=0;i<=k/A && i<=x;i++){
            if((k-i*A)%B!=0){
                continue;
            }
            int j=(k-i*A)/B;
            if(j>y) continue;
            num += ((cal(x, i)%1000000007)*(cal(y, j)%1000000007)%1000000007);
        }

        System.out.println(num);
    }
}
