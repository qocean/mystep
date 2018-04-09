package allTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int count = 0;

            for(int i=m ; i<=n ; i++){
                int number = i;
                int length = (number +"").length();
                int sum = 0;

                while(number != 0){
                    sum += (Math.pow(number%10,length));
                    number /= 10;
                }
                if(sum == i){count++; System.out.print(i + " ");}
            }
            if(count == 0) System.out.print("no");
            System.out.println();
        }
    }
}
