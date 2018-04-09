package newcoder.SwordToOffer;

import java.util.ArrayList;

/**
 *  问题描述：
 *      输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *  解题思路：
 *      从两端逼近，第一个答案必然是结果， 4+5=3+6=2+7=9  ，但是2*7才是最小的乘积
 */
public class Question42 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int head = 0 , tole = array.length-1;
        while(head<tole){
            int tempSum = array[head] + array[tole];
            if(tempSum < sum){
                head++;
            }else if(tempSum > sum){
                tole--;
            }else{
                result.add(array[head]);    result.add(array[tole]);    break;
            }
        }
        return result;
    }
}
