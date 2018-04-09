package newcoder.SwordToOffer;


import java.util.TreeSet;

/**
 *  问题描述：把数据排成最小的数
 *
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 *      打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 *      则打印出这三个数字能排成的最小数字为321323。
 *
 *
 *  解决方案：
 *      参考了一下书中的方案，将所有排列结果显示出来，然后放到一个TreeSet中，就搞定了
 */

public class Question32 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null) return null;
        String[] num_Str = parseToString(numbers);
        TreeSet<String> tree = new TreeSet<>();
        getAllPosibility(tree , num_Str , 0);
        return tree.first();
    }

    private void getAllPosibility(TreeSet<String> tree , String[] num_Str , int position){
        int length = num_Str.length;
        if(position > length-1) {
            StringBuffer sb = new StringBuffer();
            for(String s : num_Str)
                sb.append(s);
            tree.add(String.valueOf(sb));
        }else{
            for(int i=position ; i<length ; i++){
                swap(num_Str,position,i);
                getAllPosibility(tree , num_Str, position+1);
                swap(num_Str,position,i);
            }
        }
    }

    private String[] parseToString(int[] numbers){
        String[] result = new String[numbers.length];
        int i = 0;
        for(int num : numbers){
            result[i++] = num+"";
        }
        return result;
    }

    private void swap(String[] num_Str , int a , int b){
        String temp = num_Str[a];
        num_Str[a] = num_Str[b];
        num_Str[b] = temp;
    }

    public static void main(String[] args){
//        int[] nums = {3,32,321};
        int[] nums = {3334,3,3333332};
        Question32 test = new Question32();
        System.out.println(test.PrintMinNumber(nums));
    }

//    private int findMin(String[] num_Str , HashSet<Integer> selected , int position){
//        if(selected.size() == 1){
//            for(int result : selected)  return result;
//        }
//        HashSet<Integer> newSelected = new HashSet<>();
//        int min = '9' + 1;
//        for(int num : selected){
//            if(num_Str[num].length() < position+1) continue;
//            int first = num_Str[num].charAt(position);
//            if(first < min){
//                min = first;
//                newSelected.clear();
//                newSelected.add(num);
//            }else if(first == min){
//                newSelected.add(num);
//            }
//        }
//        return findMin(num_Str,newSelected,position+1);
//    }

}
