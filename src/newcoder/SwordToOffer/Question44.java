package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *      同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 *      后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *      Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Question44 {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0) return str;
        int end = str.length()-1;
        char[] chars = str.toCharArray();

        reverse(chars , 0 , end);

        int head = 0 , tole = 0;
        for(int i=0 ; i<=end ; i++){
            if(chars[i] == ' '){
                reverse(chars , head , tole-1);
                head = tole+1; tole = head;
                continue;
            }
            tole++;
        }
        reverse(chars , head , tole-1);     //这一步很关键，在最后的时候还是要进行一次翻转的
        return new String(chars);
    }

    private void reverse(char[] chars , int head , int tole){
        while(head < tole){
            char temp = chars[tole];
            chars[tole] = chars[head];
            chars[head] = temp;
            tole--; head++;
        }
    }

    public static void main(String[] args){
        Question44 test = new Question44();
        System.out.println(test.ReverseSentence("Ha am so happy"));
    }
}
