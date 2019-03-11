package level1.二分法;

public class Solution {

    /**
     * 数组有序，从小到大
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid+1
     * 中位计算方法：left + (right-left)/2
     * @param nums
     * @param target
     * @return
     */
    static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //中位数计算 （左下标 + （右 - 左）/2）
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{   //nums[mid]>target
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * x的平方根计算
     * 从   1 - x/2，去整数
     * x/mid是target，
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) left = mid + 1;
            else right = mid;
        }
        return right-1 ;
    }



    public static void main(String[] args) {
        int[] i = {1,2,3,4,5,6,7};
        int i1 = binarySearch(i, 6);
        System.out.println(i1);

        int i2 = mySqrt(100);
        System.out.println(i2);

    }



}
