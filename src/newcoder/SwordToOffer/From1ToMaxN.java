package newcoder.SwordToOffer;

import java.util.Arrays;

/**
 * 剑指offer书中第12题，给定一个整数n，从1开始打印，到最大的n位数截至
 */
public class From1ToMaxN {
    public static void main(String[] args){
        int n = 3;
        int[] number = new int[n];
        pirntAllResult(number , 0);
    }

    public static void  pirntAllResult(int[] number , int nowPosition){
        if(nowPosition >= number.length)
        {
            System.out.println(Arrays.toString(number));
        }else{
            for(int i=0 ; i<=9 ; i++){
                number[nowPosition] = i;
                pirntAllResult(number , nowPosition+1);
            }
        }
    }
}
