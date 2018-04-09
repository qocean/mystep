package meitu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> hasPassed = new HashSet<>();
        Set<String> passedLine = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] group = new int[n][n];
        for(int num = 0 ; num < m ; num++){
            int i=sc.nextInt(),j=sc.nextInt(),length=sc.nextInt();
            group[i][j] = length;
            group[j][i] = length;
        }
        int max = 0;
        for(int i=0 ; i<n ; i++){
            max = Math.max( dfs(group,n,i,hasPassed,passedLine,0) , max);
        }
        if(max==Integer.MAX_VALUE) System.out.println("YES");
        else{
            System.out.println(max);
        }
    }

    public static int dfs(int[][] group , int n , int nowPoint ,Set<Integer> hasPassed , Set<String> passedLine ,int wayCount ){
        if(n == hasPassed.size()) return wayCount;
        int max=wayCount;
        for(int i=0; i<n ; i++){
            if(hasPassed.contains(i)){
                if(passedLine.contains(getLine(nowPoint,i))) continue;
                return -1;
            }else{
                if(group[nowPoint][i] == 0) continue;
                hasPassed.add(i);
                passedLine.add(getLine(i,nowPoint));
                int temp = dfs(group,n,i,hasPassed,passedLine,wayCount+group[nowPoint][i]);
                if(temp == -1) return temp;
                else max=Math.max(max,temp);
                hasPassed.remove(i);
                passedLine.remove(getLine(i,nowPoint));
            }
        }
        return max;
    }

    public static String  getLine(int i , int j){
        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(i,j));
        sb.append(Math.max(i,j));
        return sb.toString();
    }
}
