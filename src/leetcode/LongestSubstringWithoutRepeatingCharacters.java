package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length() , result = 0 , start = 0;
        HashMap<Character , Integer> positionInString = new HashMap<>();
        for(int i=0 ; i<len ; i++){
            if(positionInString.containsKey(s.charAt(i))){
                int position = positionInString.get(s.charAt(i));
                if(position >= start)
                    start = position+1;
            }
            result = Math.max(result , i-start+1);
            positionInString.put(s.charAt(i) , i);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
