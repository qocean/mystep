package newcoder.SwordToOffer;

public class Question65 {

    int[][] hasPassed;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        hasPassed = new int[rows][cols];
        for(int i=0 ; i<rows ; i++){
            for(int j=0; j<cols ; j++){
                if(isMatching(matrix , rows , cols , i , j , str , 0))
                    return true;
            }
        }
        return false;
    }

    boolean isMatching(char[] matrix , int rows , int cols , int nowRow , int nowCol , char[] str , int nowPosition){
        //0.判定当前字符是否满足条件
        if(nowPosition >= str.length) return true;
        if(nowRow < 0 || nowRow >= rows || nowCol <0 || nowCol >= cols) return false;
        if(hasPassed[nowRow][nowCol] == 1) return false;
        int positionInMatrix = cols*(nowRow) + (nowCol);
        if(! (str[nowPosition] == matrix[positionInMatrix]))    return false;
        hasPassed[nowRow][nowCol] = 1;
        //1.左移动
        if( isMatching(matrix , rows , cols , nowRow , nowCol-1 , str , nowPosition+1))
            return true;
        //2.右移动
        if(isMatching(matrix , rows , cols , nowRow , nowCol+1 , str , nowPosition+1))
            return true;
        //3.上移动
        if(isMatching(matrix , rows , cols , nowRow-1 , nowCol , str , nowPosition+1))
            return true;

        //4.下移动
        if(isMatching(matrix , rows , cols , nowRow+1 , nowCol , str , nowPosition+1))
            return true;

        hasPassed[nowRow][nowCol] = 0;
        return false;
    }

    public static void main(String[] args){
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};

        Question65 test = new Question65();
        System.out.println(test.hasPath(matrix,3,4,str));
    }

}
