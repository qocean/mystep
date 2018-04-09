package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *  解题思路：
 *      考虑如果数组中只有一个数字出现了一次：方法是进行异或，异或到最后的值就是了
 *      题目中是两个，想办法将数组分成两个，按照剑指offer上面的方法。
 *
 *  收获：
 *      位操作，我的短板，哎。
 */

public class Question40 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int value=0;
        for(int v : array){
            value ^= v;
        }
        int make = 1;
        while(true){
            if((value^make) < value){
                break;
            }
            make *= 2;
        }
        int front = 0 , behind = array.length-1;
        while(front != behind){
            if((array[front]^make) < array[front]){
                front++;
            }else{
                swap(array,front,behind);
                behind--;
            }
        }
        if((array[front]^make) < array[front]) front++;

        value = 0;
        for(int i=0 ; i<front ; i++){
            value ^= array[i];
        }
        num1[0]=value;
        value=0;
        for(int i=front ; i<array.length ; i++){
            value ^= array[i];
        }
        num2[0]=value;
    }
    private void swap(int[] array , int a , int b){
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public static void main(String[] args){
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        Question40 test = new Question40();
        test.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0] + "       " + num2[0]);
    }
}
