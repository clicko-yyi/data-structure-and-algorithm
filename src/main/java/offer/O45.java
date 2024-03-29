package offer;


import java.util.Arrays;

/*
[面试题45. 把数组排成最小的数](https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

示例 1:
输入: [10,2]
输出: "102"

示例2:
输入: [3,30,34,5,9]
输出: "3033459"

 */
public class O45 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,30,34,5,9};
        O45 o45 = new O45();
        System.out.println(o45.minNumber(arr));
    }

    public String minNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, (x, y) -> (x + y).compareTo(y + x));
        return String.join("", numsString);
    }
}
