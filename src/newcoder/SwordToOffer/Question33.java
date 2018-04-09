package newcoder.SwordToOffer;

import java.util.ArrayList;

/**
 *  问题描述：丑数
 *
 *      把只包含因子2、3和5的数称作丑数（Ugly Number）。
 *      例如6、8都是丑数，但14不是，因为它包含因子7。
 *      习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 *
 *  解题思路：
 *
 *      按照书上的方法来的，有一个坑，就是在乘以不同的数的时候，得到一个值，例如：
 *      6=2*3，同样的6=3*2，这个时候要有一个去重复的操作才行。
 *      就是在发现重复6的时候，那么6已经在里面了，就不向里面添加了，直接对应的t(t2/t3/t5)加一就行了
 */

public class Question33 {

    public int GetUglyNumber_Solution(int index) {
        if(index <=0 ) return 0;
        ArrayList<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        int t2=0,t3=0,t5=0;
        int m2=0,m3=0,m5=0;
        int nowMax=1;
        int count = 1;
        while(count < index){
            m2 = 2*uglyNumbers.get(t2);
            while(m2<nowMax){
                uglyNumbers.add(m2);
                count++;
                t2++;
                m2 = 2*uglyNumbers.get(t2);
//                System.out.println(m2 + "     ------m2");
            }
            m3 = 3*uglyNumbers.get(t3);
            while(m3<nowMax){
                uglyNumbers.add(m3);
                count++;
                t3++;
                m3 = 3*uglyNumbers.get(t3);
//                System.out.println(m3 + "     ------m3");
            }
            m5 = 5*uglyNumbers.get(t5);
            while(m5<nowMax){
                uglyNumbers.add(m5);
                count++;
                t5++;
                m5 = 5*uglyNumbers.get(t5);
//                System.out.println(m5 + "     ------m5");
            }

            int tempMax = m2<m3?m2:m3;
            tempMax = tempMax<m5?tempMax:m5;

            if(tempMax == m2) t2++;
            else if(tempMax == m3) t3++;
            else t5++;

            if(tempMax == nowMax) continue;

            nowMax = tempMax;
            uglyNumbers.add(tempMax);
            count++;
//            System.out.println(tempMax + "       ------tempMax");
        }
        return uglyNumbers.get(index-1);
    }

//    private boolean isUglyNumber(int n){
//        while(n%2 == 0){
//            n = n/2;
//            if(uglyNumber.contains(n)) return true;
//            if(notUglyNumber.contains(n)) return false;
//        }
//        while(n%3 == 0){
//            n = n/3;
//            if(uglyNumber.contains(n)) return true;
//            if(notUglyNumber.contains(n)) return false;
//        }
//        while(n%5 == 0){
//            n = n/5;
//            if(uglyNumber.contains(n)) return true;
//            if(notUglyNumber.contains(n)) return false;
//        }
//        return n==1?true:false;
//    }

    public static void main(String[] args){
        Question33 test = new Question33();
        test.GetUglyNumber_Solution(10);
//        System.out.println(test.GetUglyNumber_Solution(10));
    }
}
