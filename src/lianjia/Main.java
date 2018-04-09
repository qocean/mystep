package lianjia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int length[] = new  int [n];
            //读取路径
            for(int i=1 ; i<=n-1 ; i++){
                int head = sc.nextInt();
                int tole = sc.nextInt();
                int l = sc.nextInt();
                int position = Math.min(tole,head);
                length[position] = l;
            }

            int q = sc.nextInt();
            for(int i=1 ; i<=q ; i++){
                int head = sc.nextInt();
                int tole = sc.nextInt();
                if(head == tole) {System.out.println(0); continue;}
                int start = Math.min(head,tole);
                int end = Math.max(head,tole);
                int result = Integer.MIN_VALUE;
                for(int position = start ; position<= end-1 ; position++){
                    result = Math.max(result,length[position]);
                }
                System.out.println(result);
                System.out.println(String.format("%.2f",result));
            }
        }
    }
//      10%
//    Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//        int n = sc.nextInt();
//        int length[] = new  int [n];
//        //读取路径
//        for(int i=1 ; i<=n-1 ; i++){
//            int head = sc.nextInt();
//            int tole = sc.nextInt();
//            int l = sc.nextInt();
//            int position = Math.min(tole,head);
//            length[position] = l;
//        }
//
//        int q = sc.nextInt();
//        for(int i=1 ; i<=q ; i++){
//            int head = sc.nextInt();
//            int tole = sc.nextInt();
//            if(head == tole) {System.out.println(0); continue;}
//            int start = Math.min(head,tole);
//            int end = Math.max(head,tole);
//            int result = Integer.MIN_VALUE;
//            for(int position = start ; position<= end-1 ; position++){
//                result = Math.max(result,length[position]);
//            }
//            System.out.println(result);
//        }
//    }
}
