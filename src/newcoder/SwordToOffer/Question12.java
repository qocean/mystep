package newcoder.SwordToOffer;



/**
 * 问题描述：
 *     给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方
 */
public class Question12 {
    public static double Power(double base, int exponent) {
        if(base == 1) return 1;
        if(exponent == 0 ) return 1;
        if(exponent == 1 ) return base;
        if(exponent < 0) {  base = 1.0/base; exponent = -exponent;}   //考虑exponent为负数的情况
        double result = Power(base , exponent/2);
        result *= result;
        if(exponent%2 != 0 ){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){

        System.out.println(Power(0.11,100));
        System.out.println(-3%2);
    }
}
