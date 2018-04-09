package datastructure.sort;

public class ShellSort {

    /**
     * 从小到达排列
     * @param arrays
     * @param n
     */
    public void staightInsertion(int[] arrays ,int n){
        int length = arrays.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<length; j += n){
                if( j+n<length && arrays[j+n]<arrays[j])    //这里如果改成大于号，那么就是由大到小排列
                    swap(arrays , j+n , j);
            }
        }
    }

    /**
     * 不断缩小区间
     * @param arrays
     */
    public void shellSort(int[] arrays){
        int increment = arrays.length/2;
        while(increment > 0){
            System.out.println(increment);
            staightInsertion(arrays , increment);
            increment /= 2;
        }
    }

    private void swap(int[] arrsys , int a , int b){
        int temp = arrsys[a];
        arrsys[a] = arrsys[b];
        arrsys[b] = temp;
    }

    public static void main(String[] args){
        int[] arrays = {9 , 1 , 5 , 8 , 3 , 7 , 4, 6 , 2 };
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arrays);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i]);
    }
}
