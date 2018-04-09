package newcoder.SwordToOffer;

public class Question34 {
    public int FirstNotRepeatingChar(String str) {
        char[] words = str.toCharArray();
        int[] count = new int[200];
        int[] positions = new int[200];
        for(int i=0 ; i<200 ; i++){
            positions[i] = -1;
        }
        int length = words.length;
        for(int i=0 ; i<length ; i++){
            if(count[words[i]] == 0){
                positions[words[i]] = i;
            }
            count[words[i]]++;
        }

        int[] sortCount = new int[length];
        for(int i=0 ; i<length ; i++){
            sortCount[i] = count[words[i]];
        }
        for(int i=0 ; i<length ; i++){
            if(sortCount[i]==1) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');

        Question34 test = new Question34();
        System.out.println(test.FirstNotRepeatingChar("google"));
    }
}
