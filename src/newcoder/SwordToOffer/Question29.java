package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *  问题描述：	最小的K个数
 *
 *      输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 *   解题思路：
 *       一个排序
 */
public class Question29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        List<Integer> temp = new ArrayList<>();
        for(int i=0 ; i<input.length ; i++){
            temp.add(input[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(k > input.length){
            return result;
        }
        Collections.sort(temp);
        for(int i=0  ; i <k ; i++){
            result.add(temp.get(i));
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = {1,2,3};
        List list = Arrays.asList(input);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
