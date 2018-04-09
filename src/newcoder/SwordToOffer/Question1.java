package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * 解题思路：
 *     从二维数组的右上角开始，如果该值小于目标值，则向左移动；如果大于，则向下移动；一直循环到找到target或超过数据界限
 */
public class Question1 {
    public class Solution {
        public boolean Find(int target, int [][] array) {
            int heigh = array.length;
            int width = array[0].length;
            int nowI = 0;
            int nowJ = width - 1;
            while(true){
                if(nowI >= 0 && nowI < heigh && nowJ >=0 && nowJ < width){
                    if(array[nowI][nowJ] == target) return true;
                    else if (array[nowI][nowJ] > target) nowJ--;
                    else  nowI++;
                }else{
                    return false;
                }
            }
        }
    }
}
