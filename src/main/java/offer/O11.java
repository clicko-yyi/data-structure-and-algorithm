package offer;

import java.util.Arrays;

/*
[剑指 Offer 11. 旋转数组的最小数字](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

示例 1：

输入：numbers = [3,4,5,1,2]
输出：1
示例 2：

输入：numbers = [2,2,2,0,1]
输出：0
 */
public class O11 {
    public static void main(String[] args) {
        O11 o11 = new O11();
        System.out.println(o11.minArray_solution_1(new int[]{3, 4, 5, 1, 2}));
        System.out.println(o11.minArray_solution_1(new int[]{2, 2, 2, 0, 1}));
    }

    public int minArray_solution_1(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public int minArray_solution_2(int[] numbers) {
        for(int i=1;i<numbers.length;i++)
            if(numbers[i]<numbers[i-1]) return numbers[i];

        return numbers[0];
    }

    public int minArray_solution_3(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}