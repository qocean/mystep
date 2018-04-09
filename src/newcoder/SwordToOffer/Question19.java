package newcoder.SwordToOffer;

import java.util.ArrayList;

/**
 * Created by QiHaiyang on 2017/7/24.
 */
public class Question19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int numbers=matrix.length*matrix[0].length;
        int zuoshang = 0 , zuoxia = 0 , youshang = matrix[0].length - 1 ,youxia = matrix.length - 1;
        while(true) {
            for(int i=zuoxia; i<=youshang; i++){
                result.add(matrix[zuoshang][i]);
            }
            zuoshang++;
            if(numbers == result.size()) break;
            for(int i=zuoshang; i<=youxia; i++)
            {
                result.add(matrix[i][youshang]);
            }
            youshang--;
            if(numbers == result.size()) break;
            for(int i=youshang; i>=zuoxia; i--){
                result.add(matrix[youxia][i]);
            }
            youxia--;
            if(numbers == result.size()) break;
            for(int i=youxia; i>= zuoshang; i--){
                result.add(matrix[i][zuoxia]);
            }
            zuoxia++;
            if(numbers == result.size()) break;
        }
        return result;
    }
}
