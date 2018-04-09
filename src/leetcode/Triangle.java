package leetcode;

import java.util.ArrayList;

public class Triangle {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[][] result = new int[n][];
        for(int i=0 ; i< n ; i++){
            result[i] = new int[i+1];
        }
        for(int i=0; i<n ; i++)
            result[n-1][i] = triangle.get(n-1).get(i);

        for(int i=n-2 ; i>=0 ; i--)
            for(int j=0; j<=i ; j++)
                result[i][j] = Math.min(result[i+1][j] , result[i+1][j+1]) + triangle.get(i).get(j);

        return result[0][0];
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> triangel = new ArrayList<>();
        ArrayList<Integer> layel1 = new ArrayList<>();      layel1.add(1);
        ArrayList<Integer> layel2 = new ArrayList<>();      layel2.add(2);  layel2.add(3);
        triangel.add(layel1);   triangel.add(layel2);
//        System.out.println(triangel.get(triangel.size()-1).get(0));
        minimumTotal(triangel);
    }
}
