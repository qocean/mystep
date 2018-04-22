package aiqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getMaxSequence(s));
    }

    public static String getMaxSequence(String s){
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int fromIndex = 0;
        while (fromIndex < chars.length){
            char maxChar = chars[fromIndex];
            for(int i = fromIndex; i < chars.length; i++){
                if(chars[i] > maxChar){
                    maxChar = chars[i];
                    fromIndex = i;
                }
            }
            fromIndex++;
            sb.append(maxChar);
        }
        return sb.toString();
    }
}
