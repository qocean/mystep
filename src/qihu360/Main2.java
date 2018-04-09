package qihu360;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for(int i=0; i<T ; i++){
            int[] nowQ = new int[3];
            int r = sc.nextInt();   nowQ[0] = r;
            int g = sc.nextInt();   nowQ[1] = g;
            int b = sc.nextInt();   nowQ[2] = b;
            Arrays.sort(nowQ);
            int temp = 0;
            int remin;
            do{
                remin = 3;
                if(nowQ[2] - 2 >=0){
                    nowQ[2] -= 2;
                    remin -= 2;
                    if(nowQ[1]-1>=0){
                        nowQ[1] -= 1;
                        remin -= 1;
                    }
                }else if(nowQ[2] - 1 >=0){
                    nowQ[2] -= 1;
                    remin -= 1;
                    if(nowQ[1]-1>=0 && nowQ[0]-1>=0){
                        nowQ[1] -= 1;
                        nowQ[0] -= 1;
                        remin -= 2;
                    }
                }
                if(remin == 0)
                    Arrays.sort(nowQ);
                else{ break ;}
            }while(++temp!=-1);

            result[i] = temp;

        }
        for(int i : result)
            System.out.println(i);
    }


}
