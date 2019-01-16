package level1.二分法;

public class Solution {

    /**
     * 数组有序，从小到大
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (left+right)/2;
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


}
