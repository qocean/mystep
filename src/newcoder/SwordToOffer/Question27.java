package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *  问题描述：字符串的排列
 *
 *      输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *      例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 *   解决方案：
 *
 *      全排列问题，这个问题很重要。
 */

public class Question27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length() == 0) return result;
        char[] cs = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        getResult(cs , 0 , set);
        result.addAll(set);
        return result;
    }

    private void getResult(char[] str, int position, TreeSet<String> result){
        int length = str.length;
        if(position > length-1) {
            result.add(String.valueOf(str));
            System.out.println(String.valueOf(str));
        }
        else{
            for(int i=position ; i<length ; i++){
                swap(str,position,i);
                getResult(str , position+1, result);
                swap(str,position,i);
            }
        }
    }

    public void swap(char[] str, int a, int b) {
        char t = str[a];
        str[a] = str[b];
        str[b] = t;
    }

    public static void main(String[] args){
        Question27 test = new Question27();
        ArrayList<String> result = test.Permutation("abc");
//        for(String temp : result)
//            System.out.println(temp);
    }

}
