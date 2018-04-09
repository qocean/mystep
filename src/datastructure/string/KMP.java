package datastructure.string;

/**
 * 字符串匹配，KMP算法
 * 算法解析：
 *    next[i]就是看第i个位置的前缀和从头开始产生的前缀相等的最大值，有公式如下：
 *    因为本算法数组小标从0开始，所以和很多书上从1开始的代码有所不同，0位置的next值要为-1才可
 */
public class KMP {
    public static void main(String[] args) {
//        char[] m = "abacab".toCharArray();
//        char[] s = "abacaabacabacabaabb".toCharArray();
        char[] m = "abcdefg".toCharArray();
        char[] s = "abacaabacabacabaabb".toCharArray();
        int[] next = new int[m.length];
        findNext(m,next);
        System.out.println(match(s,m,next));
    }

    /**
     * 获取待匹配串的next值
     * @param m
     * @param next
     */
    public static void findNext(char[] m , int[] next){
        next[0] = -1;
        int position = -1;
        for(int i=0; i<next.length-1; ){
            if(position==-1 || m[i] == m[position]) //如果position=-1,表示已经到匹配字符串的头部了
            {
                position++; i++;
                next[i] = position;
            }else{
                position = next[position];
            }
        }
    }

    /**
     * KMP匹配算法的匹配过程
     * @param s
     * @param m
     * @param next
     * @return
     */
    public static int match(char[] s , char[] m , int[] next){
        int position = 0, i=0;
        for(; i<=s.length - m.length && position<m.length;){    //约束条件为长度
            if(position ==-1 || s[i] == m[position]){
                position++;
                i++;
            }else{
                position = next[position];
            }
        }
        if(position == m.length) return i-position;
        else return 0;
    }

}
