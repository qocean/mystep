package souhu;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for(int i=0 ; i<n ; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for(int i=0 ; i< k-1 ; i++)
        {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[k-1]);
    }
}
