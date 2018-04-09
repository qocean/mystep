package toutiao2018;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aLen = sc.nextInt();
        int bLen = sc.nextInt();
        TreeSet<Integer> a = new TreeSet<>();
        TreeSet<Integer> b = new TreeSet<>();
        long sumA = 0 , sumB = 0;
        double avgA = 0.0 , avgB = 0.0;
        int numA= 0 , numB=0;
        for(int i=0 ; i<aLen ; i++) {
            int temp = sc.nextInt();
            sumA += temp;
            numA++;
            a.add(temp);
        }
        avgA = sumA*1.0/numA;
        for(int i=0 ; i<bLen ; i++){
            int temp =sc.nextInt();
            sumB += temp;
            numB++;
            b.add(temp);
        }
        avgB = sumB*1.0/numB;

        Set<Integer> moved = new HashSet<>();
        //从集合B拿数据到集合
        int count = 0;
        while(true){
            for(Integer num : b){
                if(numB == 1) break;
                if( (!moved.contains(num)) && num<avgB && num>avgA && (!a.contains(num))){
                    sumB -= num;  numB--;
                    sumA += num;  numA++;
                    avgA = sumA*1.0/numA;
                    avgB = sumB*1.0/numB;
                    count++;
                    continue;
                }
            }
            break;
        }
        System.out.println(count);
    }


}
