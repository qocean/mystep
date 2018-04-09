package leetcode;

public class PalindromePartitioningTwo {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] isPa = new boolean[length][length];
        int[] result = new int[length];

        for(int i=0; i<length ; i++)
            result[i] = length-i-1;
        for(int i=0; i<length ; i++){
            isPa[i][i] = true;
        }

        for(int i=length-1; i>=0 ; i--)
            for(int j=i; j<length; j++){
                isPa[i][j] = s.charAt(i)==s.charAt(j) && (j-i<2 || isPa[i+1][j-1]);
            }

        for(int i=length-1; i>=0 ; i--)
            for(int j=i; j<length; j++)
                if(isPa[i][j]) result[i]=Math.min(result[i], j+1>=length?length:result[j+1]+1);


        return result[0];
    }
}
