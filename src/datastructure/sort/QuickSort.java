package datastructure.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void quickSort(int[] arrays , int low , int high){
        int partitionKey;
        if(low<high){
            partitionKey = Partition(arrays , low , high);

            quickSort(arrays , low , partitionKey-1);
            quickSort(arrays , partitionKey+1 , high);
        }
    }

    private int Partition(int[] arrays , int low , int high){
        int key = arrays[low];
        while(low<high){
            while(high>low && arrays[high]>=key) high--;
            swap(arrays , low , high);
            while(low<high && arrays[low]<=key) low++;
            swap(arrays , low , high);
        }
        return low;
    }

    private void swap(int[] arrays , int a , int b){
        int temp = arrays[a];
        arrays[a] = arrays[b];
        arrays[b] = temp;
    }

    public static void main(String[] args){
        int[] arrays = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arrays , 0 , arrays.length-1);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i] + " ");
    }

}
