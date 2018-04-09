package hihocoder.offer16;

import java.util.*;

/**
 * 问题描述：
 *  描述
//     给定一个1-N的排列A[1], A[2], ... A[N]，定义集合S[K] = {A[K], A[A[K]], A[A[A[K]]] ... }。
//
//     显然对于任意的K=1..N，S[K]都是有限集合。
//
//     你能求出其中包含整数最多的S[K]的大小吗？
//
//  输入
//     第一行包含一个整数N。(1 <= N <= 100000)
//
//     第二行包含N个两两不同的整数，A[1], A[2], ... A[N]。(1 <= A[i] <= N)
//
//  输出
//     最大的S[K]的大小
//
//  样例输入
//     7
//     6 5 1 4 2 7 3
//  样例输出
//     4
 */
public class Question1 {
    public static void main(String[] args){
        Main.main(args);
    }
}

class Main{
    private Map<Integer,Integer> locationToCount = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number+1];
        for(int i = 1 ; i <= number ; i++)
            array[i] = scanner.nextInt();
        Main main = new Main();
        main.findResult(array,number);
    }

    public void findResult(int[] array , int number){
        int maxCount = 0; //最大数组大小
        //1.找到每个位置对应的数组的大小
        for(int i = 1 ; i <= number ; i++){
            if(locationToCount.containsKey(i)) continue;    //如果已经存在，则继续
            List<Integer> list = new ArrayList<>();
            int tempLocation = i;
            while(array[tempLocation] != i){
                list.add(tempLocation);
                tempLocation = array[tempLocation];
            }
            list.add(i);
            //如果当前大小已经大于当前最大值
            int size = list.size();
            if(size > maxCount) maxCount = size;
            //进行一次存储操作
            for(int key : list)
                locationToCount.put(key,size);
        }
        System.out.println(maxCount);
    }
}
