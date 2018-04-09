package newcoder.SwordToOffer;

public class Question49 {
    public int StrToInt(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        int length = chars.length;
        int start = 0;
        if(length == 0) return 0;
        int flag = 1;
        if(chars[0] == '-') { flag = -1; start = 1;}
        if(chars[0] == '+') start=1;
        for(; start < length ; start++){
            if(chars[start] >= '0' && chars[start] <= '9')
                result = result*10 + chars[start] - '0';
            else{
                return 0;
            }
        }
        return result*flag;
    }

    public static void main(String[] args){
        Question49 test = new Question49();
        System.out.println(test.StrToInt("+123"));
    }
}
