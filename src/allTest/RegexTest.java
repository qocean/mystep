package allTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主要用来测试Java正则表达式
 */
public class RegexTest {
    public static void main(String[] args){
        getNumber2("123.454jflsaureo90805sdjfo/[;[8872");
    }

    public static void getNumber(String s){
        String[] nums = s.split("[^0-9]+"); //获取数字字符，但是不能够处理小数
//        String[] nums = s.split("/d+(/./d+)?");
        for(String temp : nums){
            System.out.println(temp);
        }
    }

    public static void getNumber2(String s){
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        Matcher match = pattern.matcher(s);
        while(match.find()){
            System.out.println(match.group());
        }
    }

}
