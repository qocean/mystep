package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

//收获：String操作的replaceALL返回的是一个全新的String类型

public class Question2 {
    class Solution {
        public String replaceSpace(StringBuffer str) {
            String result = str.toString();
            String hahaha = result.replaceAll(" ","%20");
            return hahaha;
        }
    }
}
