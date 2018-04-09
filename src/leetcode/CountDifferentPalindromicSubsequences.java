package leetcode;

import java.util.HashSet;

public class CountDifferentPalindromicSubsequences {
    public int result;
    public int countPalindromicSubsequences(String S) {
        getResult("", S.toCharArray() , 0 , new HashSet<String>());
        return result;
    }

    public  void getResult(String sb , char[] s , int now , HashSet<String> set){
        //如果包含当前字符
        if(now >= s.length) {
            if(isMatch(sb) && !set.contains(sb)) {result++; set.add(sb);}
            return;
        }
        getResult(sb , s , now+1,set);
        getResult(sb+s[now] , s, now+1,set);
    }

    public  boolean isMatch(String s){
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

    public static void main(String[] args){
        CountDifferentPalindromicSubsequences solution = new CountDifferentPalindromicSubsequences();
//        System.out.println(solution.countPalindromicSubsequences("bccb"));
        System.out.println(solution.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
}
