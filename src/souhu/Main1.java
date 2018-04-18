package souhu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[10000];
        int[] taskCount = new int[10000];
        boolean[] isCountUsed = new boolean[10000];
        int lastDay = 0;
        for(int i=0 ; i<n ; i++){
            int rule = sc.nextInt();
            if(rule == 1)
            {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int group = sc.nextInt();
                lastDay = Math.max(lastDay,end);
                for(int day = start ; day <= end ; day++) {
                    if(isCountUsed[day] == true) {
                        count[day] = Math.max(count[day], group);
                    }
                    else{
                        count[day] = group;
                        isCountUsed[day] = true;
                    }
                }
            }else{
                int day = sc.nextInt();
                int group = sc.nextInt();
                lastDay = Math.max(lastDay,day);
                taskCount[day] += group;
            }
        }
        long result = 0;
        for(int i=1 ; i<= lastDay ; i++){
            result += count[i];
            result += taskCount[i];
        }
        System.out.println(result);
    }
}
