package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  问题描述：
 *      给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *      例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *      针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *      {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 */
public class Question64 {
//    public ArrayList<Integer> maxInWindows(int [] num, int size)
//    {
//        ArrayList<Integer> list = new ArrayList<>();
//        if(num.length == 0 || size == 0)   return list;
//        if(num.length < size)  return list;
//        int tempMax = findMax(num , 0 , size-1);
//        list.add(tempMax);
//        for(int i=size; i < num.length ; i++){
//            int removedNum = num[i-size];
//            if(num[i] > tempMax) tempMax = num[i];
//            if(removedNum == tempMax){
//                tempMax = findMax(num , i-size+1 , i);
//            }
//            list.add(tempMax);
//        }
//        return list;
//    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num.length == 0 || size == 0 || num.length < size)   return list;
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=0 ; i<num.length ; i++){
            if(queue.isEmpty()) queue.add(new Integer(num[i]));
            else if(num[i] > queue.getFirst().intValue()){
                queue.clear();
                queue.add(new Integer(num[i]));
            }else if(num[i] < queue.getLast()){
                queue.add(new Integer(num[i]));
            }else{
                while(num[i]>queue.getLast().intValue()){
                    queue.removeLast();
                }
                queue.add(new Integer(num[i]));
            }

            if(i>=size-1){
                if( i-size>=0 && num[i-size] == queue.getFirst().intValue()) queue.removeFirst();
                list.add(queue.peek());
            }
        }
        return list;
    }

    public static void main(String[] args){
//        int[] num = {16,14,12,10,8,6,4};
        int[] num = {2,3,4,2,6,2,5,1};
        Question64 test = new Question64();
        ArrayList<Integer> result = test.maxInWindows(num, 3);
        for(Integer i : result) System.out.print(i.intValue() + " ");
    }
}
