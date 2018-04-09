package datastructure.string;

import java.util.*;

/**
 * 打印一个字符数组能够组成的字符串的所有排列
 */
public class AllPossibleString {
    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        TreeSet<String> result = new TreeSet<>();
        getAllResult(s,0,2,result);
        for(String temp : result)
            System.out.println(temp);
    }

    public static void getAllResult(char[] s , int start , int end , TreeSet<String> result){
        if(start >= end){
            result.add(Arrays.toString(s));
        }else{
            for(int i=start ; i<=end ; i++){
                swap(s,start,i);
                getAllResult(s,start+1,end,result);
                swap(s,start,i);
            }
        }
    }

    public static void swap(char[] s , int a , int b){
        char c = s[a];
        s[a] = s[b];
        s[b] = c;
    }
}