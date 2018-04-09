package datastructure.sort;

/**
 * 直接插入排序
 */
public class StraightInsertionSort {

    /**
     * 从小到大排列
     * @param arrays
     */
    public void straightInsertionSort0(int[] arrays){
        int length = arrays.length;
        for(int i=1 ; i<length ; i++){
            for(int j=i ; j>0 ; j--){
                if(arrays[j] < arrays[j-1])
                    swap(arrays , j , j-1);
            }
        }
    }

    /**
     * 从大到小排列
     * @param arrays
     */
    public void straightInsertionSort1(int[] arrays){
        int length = arrays.length;
        for(int i=1 ; i<length ; i++){
            for(int j=i ; j>0 ; j--){
                if(arrays[j] > arrays[j-1])
                    swap(arrays , j , j-1);
            }
        }
    }


    private void swap(int[] arrsys , int a , int b){
        int temp = arrsys[a];
        arrsys[a] = arrsys[b];
        arrsys[b] = temp;
    }

    public static void main(String[] args){
        int[] arrays = {9 , 1 , 5 , 8 , 3 , 7 , 4, 6 , 2 };
        StraightInsertionSort test = new StraightInsertionSort();
        test.straightInsertionSort1(arrays);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i]);
    }
}
