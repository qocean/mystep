package newcoder.SwordToOffer;

public class Question31 {

    /**
     *  问题描述：整数中1出现的次数
     *
     *      求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有
     *      1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
     *      可以很快的求出任意非负整数区间中1出现的次数。
     *
     *
     *  解决思路：
     *      部分结果：55有16个 ，100有21个，21345有18821个
     *      以21345为例子，将21345分解成两个区域：
     *      1~20000     200001~21345
     *      第一个区域中1出现的次数就很好算了，但是要注意第一个数字是不是1
     *      如果是1，如1~1000中，四位数中1只出现了一次。
     *      例子中的1~20000区域，首位为1，则出现了10000次。
     *      剩下的思路就比较好解决了（参见剑指offer）
     *
     *
     *
     *      自己认为解决的亮点：
     *          没有一味的使用字符串来解决，结合整数特性，排除了字符串中第一个字母为0的情况，方便计算很多
     *
     */



    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        if(n==0) return 0;
        String s = n+"";
        int length = s.length();
        if(length == 1) return 1;
        int first_num = s.charAt(0)-'0';
        int remain = n - (int) Math.pow(10 , length-1)*first_num;
        //1.计算整数部分
        if(first_num == 1){
            result += 1;
            result += remain;  //别忘了把后面算上
            result += (length-1)*Math.pow(10,length-2);
        }else {
            //这里第一位不可能是0，因为是从int转换过来的
            result += Math.pow(10,length-1);
            result += first_num*(length-1)*Math.pow(10,length-2);
        }
        //2.计算剩下的部分
        result += NumberOf1Between1AndN_Solution(remain);
        return result;
    }



    public static void main(String[] args){
        Question31 test = new Question31();
        System.out.println(test.NumberOf1Between1AndN_Solution(21345));
    }
}
