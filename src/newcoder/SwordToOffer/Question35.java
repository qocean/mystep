package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *      输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 *      即输出P%1000000007
 */
public class Question35 {
    public static final int mod = 1000000007;

    public int InversePairs(int [] array) {
        int result = 0;
        result = mergeSort(array,0,array.length-1);
        return result;
    }

    private int mergeSort(int[] array , int start , int end ){
        int result = 0;
        if(start >= end) return 0;
        else{
            int mid = (end+start)/2;
            result += mergeSort(array , start , mid);
            result %= mod;
            result += mergeSort(array , mid+1 , end);
            result %= mod;
            result += sort(array , start , mid , end);
        }

        return result%mod;
    }

    private int sort(int[] array , int start , int mid , int end){
        int length = end-start+1;
        int[] temp = new int[length];
        int k=0,head=start,tole=mid+1,count=0;
        while(head<=mid && tole<=end){
            if(array[head] > array[tole]){
                temp[k++] = array[tole++];
                count += (mid-head+1);
                count %= mod;
            }else{
                temp[k++] = array[head++];
            }
        }
        while(head<=mid) temp[k++] = array[head++];
        while(tole<=end) temp[k++] = array[tole++];
        k=0;head=start;
        while(k<length) array[head++]=temp[k++];
        return count;
    }


    private void swap(int[] array , int position_a , int position_b){
        int t = array[position_a];
        array[position_a] = array[position_b];
        array[position_b] = t;
    }

    public static void main(String[] args){
//        int[] array = {8,7,6,5,4,3,2,1};
        int[] array = {1,2,3,4,5,6,7,0};
        Question35 test = new Question35();
        System.out.println(test.InversePairs(array));
        for(int a : array){
            System.out.print(a + " ");
        }
    }
}
