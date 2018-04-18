package toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i<n ; i++){
            TreeSet<Double> set = new TreeSet<>();
            Map<Double , String> map = new HashMap<>();
            String[] nums = sc.nextLine().split(" ");
            int K = Integer.parseInt(nums[0]);
            for(int j=1 ; j<nums.length ; j++){
                for(int k=1; k<j ; k++){
                    double value = Integer.parseInt(nums[k])*1.0 / Integer.parseInt(nums[j]);
                    set.add( value );
                    map.put(value , nums[k] + "#" + nums[j]);
                }
            }
            int k=1;
            for(Double d : set){
                if(k==K){
                    String[] temp = map.get(d).split("#");
                    System.out.println(temp[0] + " " + temp[1]);
                    break;
                }
                k++;
            }
        }
    }
}
