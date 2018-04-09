package jingdong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s.length()==0) {
            System.out.println(0); return;
        }
        long num = 0;
        int N = s.length() , i=1;
        int j, flag;
        int times = (int) Math.pow(N,2);
        StringBuilder sb = null;
        while(i<times){
            j=0;
            flag=1;
            sb = new StringBuilder();
            while(j<N){
                if((i&flag) != 0)
                    sb.append(s.charAt(j));
                j++;
                flag *= 2;
            }
            if(isMatch(sb.toString()))
                num++;
            i++;
        }
        System.out.println(num);
    }


    public static boolean isMatch(String s){
        char[] chars = s.toCharArray();
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        int start = 0 , end = chars.length-1;
        while(start < end){
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
