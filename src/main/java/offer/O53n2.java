package offer;

import java.util.HashSet;
import java.util.Set;

/*
[剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/)

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例 1:
输入: [0,1,3]
输出: 2

 */
public class O53n2 {
    public static void main(String[] args) {

    }

    public int missingNumber_solution_1(int[] nums) {
        int ret = -1;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int i = 0; i <= n; i++) {
            if(!set.contains(i)){
                ret = i;
                break;
            }
        }

        return ret;
    }

    public int missingNumber_solution_2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return n;
    }

    public int missingNumber_solution_3(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public int missingNumber_solution_4(int[] nums) {
        int n = nums.length;
        int sum = n * (n - 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public int missingNumber_solution_5(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
