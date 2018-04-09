package toutiao2018;


import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        int[] highs = new int[N];
        int i = 0;
        for(i=0 ; i< N ; i++){
            highs[i] = sc.nextInt();
        }
        Arrays.sort(highs);
        int nowHigh = 0;
        i=0;
        if( (nowHigh+H) < highs[0]) {System.out.println(0); return;}
        while(K>0){
            if(i<N && highs[i] < (nowHigh+H) ){ i++; }
            else if(i<N && highs[i] >= (nowHigh+H)){
                if(highs[i] > (nowHigh+H) ) i--;
                nowHigh = nowHigh + (highs[i] - nowHigh)*2;
                while(i<N && nowHigh > highs[i]) i++;
                K--;
            }else{
                if(nowHigh < highs[N-1]) {
                    nowHigh = nowHigh + (highs[N - 1] - nowHigh) * 2;
                    K--;
                }
                break;
            }
        }
        System.out.println(nowHigh);
    }
}
