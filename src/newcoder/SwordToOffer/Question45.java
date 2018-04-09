package newcoder.SwordToOffer;

import java.util.Arrays;

public class Question45 {

    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfTemp = 0;
        int length = numbers.length;
        if(length == 0) return false;
        for(int i=0 ; i<length-1 ; i++){
            int temp = numbers[i+1] - numbers[i];
            if(numbers[i] == 0 ) numberOfZero++;
            else if(temp == 0) return false;
            else if(temp == 1) continue;
            else{
                numberOfTemp += temp - 1;
            }
        }
        if(numberOfZero >= numberOfTemp) return true;
        return false;
    }

    public static void main(String[] args){
        Question45 test = new Question45();
        int[] numbers  = {0,3,1,6,4};
        System.out.println(test.isContinuous( numbers ));
    }
}
