package javabase;

public class EqualsJudging {

    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");

        System.out.println(s1==s2);
        System.out.println(s2==s3);
    }
}
