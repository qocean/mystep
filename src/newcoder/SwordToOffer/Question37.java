package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      统计一个数字在排序数组中出现的次数。
 *
 *  解题思路：
 *      看到数组是有序的，第一反映就是借助二叉搜索
 */

public class Question37 {
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length==0) return 0;
        return binarySearch(array,0 , length-1 , k);
    }

    private int binarySearch(int[] array , int start , int end , int k){
        int mid =(start+end)/2;
        int count = 0;
        if(k<array[start] || k>array[end]) return 0;
        if(start == end && array[start] == k) return 1;
        if(k >= array[mid+1]){
            count += binarySearch(array,mid+1 , end , k);
        }
        if(k <= array[mid]){
            count += binarySearch(array , start , mid , k);
        }
        return count;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,5,6,7,8,9};
        Question37 test = new Question37();
        System.out.println(test.GetNumberOfK(array,5));
    }
}
