package qunar;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] seats = new int[n];
        for(int i=0 ; i<n ; i++)
            seats[i] = sc.nextInt();

        int result = isSuitable(m,seats,0,0);
        if(result == 2) System.out.println("perfect");
        else System.out.println("good");
    }

    public static int isSuitable(int m , int seats[] , int nowCompany , int selectedSeats){
        if(selectedSeats == m) return 2;
        else if(selectedSeats > m) return 1;
        else{
            if(nowCompany < seats.length)
                return Math.max( isSuitable(m,seats,nowCompany+1 , selectedSeats+seats[nowCompany]),
                    isSuitable(m,seats,nowCompany+1,selectedSeats));
        }
        return 0;
    }
}

interface A {

}

interface B extends A{

}