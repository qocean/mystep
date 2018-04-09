package datastructure.sort;

/**
 * 归并排序
 */
public class MergingSort {

    public void mergingSort(int[] arrays , int start , int end){
        if(end <= start) return;
        int mid = (end + start)/2;
        mergingSort(arrays , start ,mid);
        mergingSort(arrays , mid+1 , end);

        int[] tempArray = new int[end - start + 1];
        int i=start , j = mid+1 , m = 0;
        for(; i<= mid && j<=end ; ){
            if(arrays[j] < arrays[i])
            {
                tempArray[m++] = arrays[j++];
            }else{
                tempArray[m++] = arrays[i++];
            }
        }
        if(i > mid){
            for(; j<=end;)   tempArray[m++] = arrays[j++];
        }else{
            for(;i<=mid;) tempArray[m++] = arrays[i++];
        }
        i = start;
        for(m=0 ; m<tempArray.length ;){
            arrays[i++] = tempArray[m++];
        }
    }

    private void swap(int[] arrays , int a , int b){
        int temp = arrays[a];
        arrays[a] = arrays[b];
        arrays[b] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        MergingSort mergingSort = new MergingSort();
        mergingSort.mergingSort(arrays,0,arrays.length-1);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i] + " ");
    }
}
