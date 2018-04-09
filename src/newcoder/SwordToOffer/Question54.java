package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 *  问题描述：
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *      当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 */
public class Question54 {
    private List<Character> list = new ArrayList<>();
    int[] count = new int[200];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        list.add(new Character(ch));
        count[ch] = count[ch] + 1;
        System.out.println(count[ch]);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Character c : list){
            if(count[c] == 1) return c.charValue();
            else{
                continue;
            }
        }
        return '#';
    }

    public static void main(String[] args){
        Question54 test = new Question54();
        char[] str = { 'g','o','o','g','l','e'};
        for(char c :str){
            test.Insert(c);
            System.out.print(test.FirstAppearingOnce());
        }
    }
}
