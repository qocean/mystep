package datastructure.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 从小到大排列
     * @param arrays
     */
    public void bubbleSort0(int[] arrays){
        int length  = arrays.length;
        for(int i=0 ; i<length ; i++)
            for(int j=length-1 ; j>i ; j--){
                if(arrays[j] < arrays[j-1]) swap(arrays,j,j-1);
            }
    }

    /**
     * 从大到小排列
     * @param arrays
     */
    public void bubbleSort1(int[] arrays){
        int length  = arrays.length;
        for(int i=0 ; i<length ; i++)
            for(int j=length-1 ; j>i ; j--){
                if(arrays[j] > arrays[j-1]) swap(arrays,j,j-1);
            }
    }

    private void swap(int[] arrsys , int a , int b){
        int temp = arrsys[a];
        arrsys[a] = arrsys[b];
        arrsys[b] = temp;
    }

    public static void main(String[] args){
        int[] arrays = {9 , 1 , 5 , 8 , 3 , 7 , 4, 6 , 2 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort0(arrays);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i]);
    }
}
