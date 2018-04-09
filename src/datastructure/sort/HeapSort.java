package datastructure.sort;

/**
 * 堆排序
 * ps:从小到大排序需要建立大顶堆，从大到小排序需要构建小顶堆
 *    每次将堆顶元素放置于末尾，认为数组长度减少1
 *    在构建大（小）顶堆，每更改一次都要考虑对应的子树是否仍旧是满足条件的堆
 *
 *    不稳定的排序
 */
public class HeapSort {

    /**
     * 从小到大排序
     * @param arrays
     */
    public void heepSort1(int[] arrays){
        int length = arrays.length;
        //1.构建大顶堆
        for(int i=length/2; i>0 ; i--){
            adjust(arrays , i , length);
        }

        //2.不断剔除堆顶的元素
        for(int i=length ; i>1 ; i--){
            int temp = arrays[0];
            arrays[0] = arrays[i-1];
            arrays[i-1] = temp;

            adjust(arrays ,1 , i-1);
        }
    }

    /**
     *
     * @param arrays
     * @param i
     */
    private void adjust(int[] arrays , int i , int size){
        int temp = arrays[i-1],j;
        for(j=2*i ; j<=size ; j*=2){
            if(j<size && arrays[j-1] < arrays[j+1-1]){
                //这里的j<size很关键，避免数组越界问题，如果j==size，那么就是最后一个需要被比较的元素了
                j++;
            }
            if(temp > arrays[j-1])
                break;

            arrays[i-1] = arrays[j-1];
            i = j;
        }
        arrays[i-1] = temp;
    }



    public static void main(String[] args){
        int[] arrays = {50,10,90,30,70,40,80,60,20};
        HeapSort heapSort = new HeapSort();
        heapSort.heepSort1(arrays);
        for(int i=0 ; i<arrays.length ; i++)
            System.out.print(arrays[i] + " ");
    }
}
