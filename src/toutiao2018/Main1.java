package toutiao2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int value = sc.nextInt();
        Set<Integer> nums = new HashSet<>();
        for(int i=0 ; i<number ; i++){
            nums.add(sc.nextInt());
        }
        long count = 0;
        for(Integer i : nums){
            if(nums.contains(i+value)) count++;
        }
        System.out.println(count);
    }
}
