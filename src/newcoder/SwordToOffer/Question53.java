package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *      例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *      但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Question53 {

    public boolean isNumeric(char[] str) {
        if(str.length == 0) return false;
        int start = 0;
        if(str[start] == '+' || str[start]=='-'){
            if(str.length == 1) return false;
            start++;
        }

        int numberOfPoint = 0;
        for(; start < str.length ; start++){
            if( (str[start] >= '0' && str[start] <= '9'))
                continue;
            else if(str[start] == '.' && numberOfPoint < 1 && start+1 < str.length){
                numberOfPoint++; continue;
            }else if(str[start] == 'E' || str[start] == 'e'){
                if(start+1 < str.length && (str[start+1] == '+' || str[start+1] == '-')){
                    return isInteger(str , start+2);
                }else if(start+1<str.length && str[start+1] >= '0' && str[start+1] <= '9'){
                    return isInteger(str , start+1);
                }
                else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(char[] str ,int start){
        if(start >= str.length) return false;
        while(start < str.length){
            if(str[start] >= '0' && str[start] <= '9'){
                start++;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        char[] str = {'1','0','0'};
        Question53 test = new Question53();
        System.out.println(test.isNumeric(str));

    }
}
