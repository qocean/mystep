package datastructure.sort;

/**
 * 简单选择排序
 */
public class SimpleSelectionSort {

    /**
     * 从小到达排列
     * @param arrays
     */
    public void simpleSelection0(int[] arrays){
        int length = arrays.length;
        for(int i=0; i<length-1; i++){
            int position = i;
            int min = arrays[i];
            for(int j=i+1; j<length; j++){
                if(arrays[j] < min){
                    min = arrays[j];
                    position = j;
                }
            }
            swap(arrays , i ,position);
        }
    }

    /**
     * 从大到小排列
     * @param arrays
     */
    public void simpleSelection1(int[] arrays){
        int length = arrays.length;
        for(int i=0; i<length-1; i++){
            int position = i;
            int max = arrays[i];
            for(int j=i+1; j<length ; j++){
                if(arrays[j] > max){
                    max = arrays[j];
                    position = j;
                }
            }
            swap(arrays , i ,position);
        }
    }

    private void swap(int[] arrsys , int a , int b){
        int temp = arrsys[a];
        arrsys[a] = arrsys[b];
        arrsys[b] = temp;
    }


    public static void main(String[] args){
        int[] arrays = {9 , 1 , 5 , 8 , 3 , 7 , 4, 6 , 2 };
        SimpleSelectionSort bubbleSort = new SimpleSelectionSort();
        bubbleSort.simpleSelection1(arrays);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i]);
    }

}
