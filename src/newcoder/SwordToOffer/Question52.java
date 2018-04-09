package newcoder.SwordToOffer;


/**
 *  问题描述：
 *      请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *      在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 *  解题思路：
 *      有限状态机，通过递归来缓解使用循环带来的不变，主要要考虑的是两个问题：
 *          1) * 符号的判定
 *          2) 注意数组越界问题
 */
public class Question52 {
    public boolean match(char[] str, char[] pattern)
    {

        return matchChar(str , 0 , pattern , 0);
    }

    public boolean matchChar(char[] str , int str_i , char[] pattern ,int pattern_i){
        if(str_i >= str.length && pattern_i >= pattern.length)  return true;
        if(str_i < str.length && pattern_i >= pattern.length)   return false;

        if( pattern_i+1 < pattern.length && pattern[pattern_i + 1] == '*'){
            if(str_i >= str.length) return matchChar(str , str_i , pattern , pattern_i+2);
            if(pattern[pattern_i] == str[str_i] ||(pattern[pattern_i] == '.' && str_i < str.length) ){
                return matchChar(str,str_i+1 , pattern , pattern_i+2)||
                        matchChar(str , str_i+1 , pattern , pattern_i)||
                        matchChar(str,str_i , pattern , pattern_i+2);
            }else{
                return matchChar(str , str_i , pattern , pattern_i+2 );
            }
        }

        if( str_i < str.length && (str[str_i] == pattern[pattern_i] || pattern[pattern_i] == '.') ){
            return matchChar(str , str_i+1 , pattern , pattern_i+1);
        }

        return false;
    }

    public static void main(String[] args){
        Question52 test = new Question52();
        char[] str = {'a','a','a'};
        char[] pattern = {'a','*','a'};
        System.out.println(test.match(str,pattern));
    }
}
