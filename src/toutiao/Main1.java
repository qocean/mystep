package toutiao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] finalResult = new long[n];
        for(int i=0 ; i<n ; i++){
            long m = sc.nextLong();
            long[] array = new long[(int)m];
            Set<Long> set = new HashSet<>();

            for(int j=0 ; j<m ; j++){ array[j] = sc.nextLong();  set.add(array[j]); }
            int T = 1;
            for(;;T++){
                int k=0;
                for(; k<m ; k++){
                    if(array[k] - T >= array[0]){
                        if(!set.contains(array[k] - T)) break;
                    }
                    if(array[k] + T <= array[(int)m-1]) {
                        if(!set.contains(array[k] + T)) break;
                    }
                }
                if(k>=m) break;
            }
            finalResult[i] = T;
        }
        for(long temp : finalResult)
            System.out.println(temp);
    }
}
