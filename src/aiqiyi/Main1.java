package aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        System.out.println(getCount(x, y, z));
    }

    public static int getCount(int x, int y, int z){
        int count = 0;

        int[] nums = new int[]{x, y, z};
        Arrays.sort(nums);
        int d1 = (nums[2] - nums[0]) / 2;
        int d2 = (nums[2] - nums[1]) / 2;
        count += d1;
        count += d2;
        nums[0] += 2 * d1;
        nums[1] += 2 * d2;

        if(nums[0] == nums[1]){
            if(nums[1] == nums[2]){
                return count;
            }
            return count + 1;
        }
        return count + 2;
    }
}
