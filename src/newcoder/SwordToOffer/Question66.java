package newcoder.SwordToOffer;

public class Question66 {
    int[][] matrix;
    public int movingCount(int threshold, int rows, int cols)
    {
        matrix = new int[rows][cols];
        int result = 0;
        move(threshold , rows ,cols , 0 , 0);

        for(int i=0 ; i<rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) result++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }

    void move(int threshold , int rows , int cols , int nowRow , int nowCols){
        if(nowRow<0 || nowRow >= rows || nowCols <0 || nowCols >= cols) return;
        if(!judge(nowRow , nowCols , threshold) ) return;
        if(matrix[nowRow][nowCols] == 1) return;
        matrix[nowRow][nowCols] = 1;

        //左
        move(threshold , rows , cols , nowRow , nowCols-1);
        //右
        move(threshold , rows , cols , nowRow , nowCols+1);
        //上
        move(threshold , rows , cols , nowRow-1 , nowCols);
        //下
        move(threshold , rows , cols , nowRow+1 , nowCols);
    }

    boolean judge(int nowRow , int nowCols , int threshold){
        int sum = 0;
        while(nowRow != 0){
            sum += (nowRow%10);
            nowRow /= 10;
        }

        while(nowCols != 0){
            sum += (nowCols%10);
            nowCols /= 10;
        }
        if(sum > threshold){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Question66 test = new Question66();
        System.out.println(test.movingCount(5,10,10));
    }
}
