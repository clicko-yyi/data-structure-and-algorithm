package offer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
[剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2

*/
public class O39 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        O39 o39 = new O39();
        System.out.println(o39.majorityElement_solution_4(arr));
    }

    public int majorityElement_solution_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) { map.put(num, map.getOrDefault(num, 0) + 1); }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(maxEntry == null || maxEntry.getValue() < entry.getValue()){
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public int majorityElement_solution_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement_solution_3(int[] nums) {
        Random random = new Random();

        while(true){
            int index = randRange(random, 0, nums.length);
            if(countOccurences(nums, nums[index]) > nums.length /2){
                return nums[index];
            }
        }
    }
    private int randRange(Random random, int min, int max){
        return random.nextInt(max - min)  + min;
    }

    private int countOccurences(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement_solution_4(int[] nums) {
        return majorityElement_recursion(nums, 0, nums.length-1);
    }

    private int majorityElement_recursion(int[] nums, int lo, int hi){
        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + ((hi - lo) >> 1);

        int left = majorityElement_recursion(nums, lo, mid);
        int right = majorityElement_recursion(nums, mid+1, hi);
        if (left == right) {
            return left;
        }

        int leftCount = countOccurencesRange(nums, left, lo, mid);
        int rightCount = countOccurencesRange(nums, right, mid+1, hi);
        return leftCount > rightCount ? left : right;
    }

    private int countOccurencesRange(int[] nums, int target, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if(nums[i] == target){
                count++;
            }
        }
        return count;
    }

    public int majorityElement_solution_5(int[] nums) {
        int count = 0;
        int candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
