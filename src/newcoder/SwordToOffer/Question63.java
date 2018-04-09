package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  问题描述：
 *      如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */
public class Question63 {
    List<Integer> numbers = new ArrayList<>();
    public void Insert(Integer num) {
        numbers.add(num);
    }

    public Double GetMedian() {
        int length = numbers.size();
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.intValue() > o2.intValue())
                    return 1;
                else if(o1.intValue() == o2.intValue())
                    return 0;
                else{
                    return -1;
                }
            }
        });
        if(length%2 == 0){
            return 1.0 * (numbers.get((length-1)/2).intValue() + numbers.get((length-1)/2+1).intValue())/2;
        }else{
            return numbers.get((length-1)/2).doubleValue();
        }
    }
}
