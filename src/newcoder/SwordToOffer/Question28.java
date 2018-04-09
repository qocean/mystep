package newcoder.SwordToOffer;

import java.util.HashMap;
import java.util.Map;


/**
 * 问题描述：数组中出现次数超过一半的数字
 *
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Question28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int result = 0;
        int half = array.length/2;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0 ; i<array.length ; i++){
            if(!countMap.containsKey(array[i])){
                countMap.put(array[i],0);
            }
            countMap.put(array[i],countMap.get(array[i])+1);
            if(countMap.get(array[i]) > half){
                result = array[i];
                return result;
            }
        }
        return 0;
    }
}
