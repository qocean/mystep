package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题描述：
 *      小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *      但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 *      没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *      现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 *  解题思路：
 *      参考Question42的问题，比较有帮助
 */
public class Question41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int head = 1 , tole = 2;
        while(head < tole){
            int tempSum = getSum(head,tole);
            if(tempSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=head ; i <= tole ; i++)  list.add(new Integer(i));
                result.add(list);
                //当满足条件的时候，重新开始就可以了，下面代码很重要
                tole++;
            }else if(tempSum < sum){
                tole++;
            }else{
                head++;
            }
        }
        return result;
    }

    private int getSum(int a , int b){
        int result = 0;
        for(int i=a ; i <= b ; i++) result+=i;
        return result;
    }

    public static void main(String[] args){
        Question41 test = new Question41();
        ArrayList<ArrayList<Integer>> result = test.FindContinuousSequence(3);
    }
}
