package qunar;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String startNode = sc.nextLine();
        char[] cs = startNode.toCharArray();
        String endNode = "";
        for(int i=cs.length-1; i>=0 ; i--)
            endNode += cs[i];
        String secondLine = sc.nextLine();
        if(cs.length==1 ) {System.out.println(1); return;}
        String[] possible = secondLine.split(" ");
        Set<String> hasPassed = new HashSet<>();
        hasPassed.add(startNode);

        System.out.println(findNext(possible,hasPassed,startNode,endNode));
    }

    public static int findNext(String[] possible , Set<String> hasPassed , String nowNode , String endNode){
        if(isPossible(nowNode,endNode)) return hasPassed.size()+1;
        int result = 99;
        for(String temp : possible){
            if(hasPassed.contains(temp) || !isPossible(nowNode,temp) ) continue;
            hasPassed.add(temp);
            result = Math.min(result , findNext(possible,hasPassed,temp,endNode));
            hasPassed.remove(temp);
        }
        return result;
    }

    public static boolean isPossible (String s1 , String s2){
        int count = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0 ; i<c1.length ; i++){
            if(c1[i] != c2[i]) count++;
        }
        if(count == 1) return true;
        else return false;
    }
}

