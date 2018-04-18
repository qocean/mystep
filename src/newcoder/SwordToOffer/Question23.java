package newcoder.SwordToOffer;

public class Question23 {

    /**
     * 问题描述：二叉搜索树的后序遍历序列
     *
     *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * 解题思路：
     *      后续遍历的最后一个肯定是根节点，这样通过和最后一个元素的大小比较，就可以把一棵树分成两个子树。子树中一部分是比根节点都小的，
     *  一部分是比跟节点都大的，如果小的里面出现了大的（或者大的里面出现了小的），那么这个树就不对，反之则正确。
     *      通过自顶向下的方式来解决这个问题。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)    return false;
        return testSubArray(0 , sequence.length-1 , sequence);
    }

    public boolean testSubArray(int start , int end , int[] sequence){
        if(start >= end)    return true;
        //1.找到根节点
        int root = sequence[end];
        //2.通过根节点把两个树进行划分
        int depart = 0;
        for(int i = start ; i < end ; i++){
            if(sequence[i] > root){
                depart = i;
                break;
            }else if(i == end-1){
                depart = i+1;
            }else{
                continue;
            }
        }
        //3.判断大于的部分是否有小于root的值，因为小于的部分已经比较过，所以这里就不用了
        for(int i = depart ; i < end ; i++){
            if(sequence[i] < root) {
                System.out.println("触发false机制" + sequence[i] + "   root=" + root);
                return false;
            }
        }
        System.out.println("划分子树： " +  start  + "---" + (depart-1) + "---" + (end-1));
        boolean result = testSubArray(start,depart-1 , sequence) && testSubArray(depart,end-1,sequence);
        return result;
    }

    public static void main(String args[]){
        Question23 test = new Question23();
        int[] sequence = {1,2,4,3,8,7,10,9,6};
//        int[] sequence = {[4,8,6,12,16,14,10]};
//        int[] sequence = {1,2,3,4,5};
        System.out.println(test.VerifySquenceOfBST2(sequence));
    }

    /**
     * 二刷
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST2(int [] sequence){
        if(sequence.length <= 0) return false;
        return findAnswer(sequence , 0 , sequence.length-1);
    }

    public boolean findAnswer(int[] sequence , int start , int end){
        if(start >= end) return true;
        int mid = start;
        while(mid<end && sequence[mid]<sequence[end]) mid++;
        int position = mid;
        while(position<end && sequence[position]>sequence[end]) position++;
        if(position < end) return false;
        return findAnswer(sequence,start ,mid-1) && findAnswer(sequence,mid,end-1);
    }


}
