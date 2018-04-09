package jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
        List<String> result = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            boolean changeUsed = true;
            int leftCount = 0;
            count = 0;
            char[] line = sc.nextLine().trim().toCharArray();
            for(char c : line){
                if(c == '('){
                    count++;
                    leftCount++;
                }else{
                    if(count == 0 && changeUsed){ changeUsed = false;}
                    else if(count<=0 && !changeUsed){
                        count = -1;
                        break;
                    }
                    count--;
                }
            }
            if(count == 0 && leftCount>=2 ) result.add("Yes");
            else{
                result.add("No");
            }
        }
        for(String temp : result)
            System.out.println(temp);
    }
}
