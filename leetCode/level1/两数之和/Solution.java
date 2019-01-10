package level1.两数之和;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {

    public static void main(String[] args) {
        int []nums = {3,2,4};
        int tar = 10;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, tar);
        for(int i = 0 ; i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    /**
     * 暴力法
     * 时间复杂度：O(n^2)，对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2))。 2重循环
     * 空间复杂度：O(1)。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int count = 0 ;
        int len  = nums.length;
        for(int i = 0; i< len;i++){
            for(int j = i+1;j<len;j++){
                count++;
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        System.out.println(count);
        throw new IllegalArgumentException("没有结果");
    }

    public int[] twoSum1(int[] nums, int target) {
        return null;
    }

}
