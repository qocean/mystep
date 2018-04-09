package jingdong;

import java.util.Scanner;

public class Main1_2 {
    public static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.length() == 0) {
            System.out.println(0);
            return;
        }
        getResult("", s.toCharArray() , 0);
        System.out.println(result);
    }

    public static void getResult(String sb , char[] s , int now){
        //如果包含当前字符
        if(now >= s.length) {
            if(isMatch(sb)) result++;
            return;
        }
        getResult(sb , s , now+1);
        getResult(sb+s[now] , s, now+1);
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
