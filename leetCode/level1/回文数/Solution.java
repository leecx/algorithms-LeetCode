package level1.回文数;

import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class Solution {

    //字符串判断
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        StringBuilder num = new StringBuilder(Integer.valueOf(x).toString());
        String temp = num.toString();
        num.reverse();
        if(temp.equals(num.toString())){
            return true;
        }
        return false;
    }

    public boolean isPalindrome1(int x) {
        if(x < 0){
            return false;
        }


        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
    }




}
