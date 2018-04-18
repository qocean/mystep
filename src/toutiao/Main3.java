package toutiao;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        int n = sc.nextInt();
        for(int i=0 ; i<n ; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            long count = 0;
            for(int k=0 ; k<op.length() ; k++) {
                char c = op.charAt(k);
                if(startX > 0 && startX <= N && startY > 0 && startY <= M) {
                    count++;
                    switch(c){
                        case 'u' : startX--; break;
                        case 'd' : startX++; break;
                        case 'l' : startY--; break;
                        case 'r' : startY++; break;
                    }
                }else{
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
