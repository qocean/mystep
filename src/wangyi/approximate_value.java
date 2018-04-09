package wangyi;

import java.util.Scanner;

public class approximate_value {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int weight = scan.nextInt();
        if(num==0) {System.out.println(1); return;}
        int[] numarr = new int[num];
        for(int i=0;i<num;i++){
            numarr[i] = scan.nextInt();
        }
        int[][] result = new int[num][weight+1];
        for(int i=0;i<num;i++){
            for(int j =1;j<=weight;j++){
                if(i>0){
                    if(j-numarr[i]>=0){
                        result[i][j] = result[i-1][j]+result[i-1][j-numarr[i]]+1;
                    }else{
                        result[i][j] = result[i-1][j];
                    }

                }else{
                    if(numarr[i]<=weight){
                        result[i][j]=1;
                    }else{
                        result[i][j]=0;
                    }
                }
            }
        }
        System.out.println(result[num-1][weight]+1);
    }

}
