package offer;

import java.util.Arrays;
/*
[剑指 Offer 57. 和为s的两个数字](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/)
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
 */
public class O57 {

    public static void main(String[] args) {
        O57 o57 = new O57();
        System.out.println(Arrays.toString(o57.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }
}
