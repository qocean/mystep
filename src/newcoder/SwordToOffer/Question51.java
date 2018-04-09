package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 *  解题思路：
 *      参考的答案，没想到可以通过拆分来解决这样的问题！！！！！！
 */
public class Question51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];

        C[0] = 1;
        for(int i=1 ; i<A.length ; i++){
            C[i] = C[i-1] * A[i-1];
        }

        D[A.length-1] = 1;
        for(int i=A.length-2 ; i>=0 ; i--){
            D[i] = D[i+1] * A[i+1];
        }

        for(int i=0 ; i<A.length ; i++)
            B[i] = C[i]*D[i];

        return B;
    }

    public static void main(String[] args){
        Question51 test = new Question51();
        int[] A = {1,2,3,4,5};
        System.out.println(test.multiply(A));
    }

}
