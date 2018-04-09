package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

/**
 * 解题思路：
 *     设立两个新的数组，分别存放奇数和偶数，然后再将两个数组合并
 */
public class Question13 {
    public void reOrderArray(int [] array) {
        int[] jishu = new int[array.length];
        int[] oushu = new int[array.length];
        int jishuCount = 0,oushuCount = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i]%2 == 1) jishu[jishuCount++] = array[i];
            else oushu[oushuCount++] = array[i];
        }
        for(int i = 0 ; i < jishuCount ; i++)   array[i] = jishu[i];
        for(int i = 0 ;i < oushuCount ; i++) array[i+jishuCount] = oushu[i];
    }

}
