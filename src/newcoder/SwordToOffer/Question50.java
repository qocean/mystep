package newcoder.SwordToOffer;

/**
 * 问题描述：
 *      在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *      也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *      例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 *  解题思路：
 *      设置标志位
 */
public class Question50 {

    /**
     * 这个方法用了空间复杂度为O(n)，下面有空间复杂度为0的方法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length < 2) return false;
        int[] count = new int[length];
        for(int i=0 ; i<length ; i++){
            if(count[numbers[i]] == 0) count[numbers[i]] += 1;
            else{
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 不用额外空间的方法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate2(int numbers[],int length,int [] duplication){
        if(length < 2) return false;
        for(int i=0 ; i<length ;){
            if(numbers[i] == i) i++;
            else{
                if(numbers[i] == numbers[numbers[i]]) {duplication[0] = numbers[i];  return true;}
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Question50 test = new Question50();
        int[] array = {2,3,1,0,2,5,3};
        test.duplicate2(array , 7 , new int[1]);
    }
}
