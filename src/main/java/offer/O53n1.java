package offer;

/*
[剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)
统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
 */
public class O53n1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        O53n1 o53n1 = new O53n1();
        System.out.println(o53n1.search_solution_1(arr, 7));
        System.out.println(o53n1.search_solution_1(arr, 8));
        System.out.println(o53n1.search_solution_1(arr, 5));
        System.out.println(o53n1.search_solution_1(arr, 6));
    }

    public int search_solution_1(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int index = -1;
        int count = 0;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    hi = mid - 1;
                } else {
                    index = mid;
                    break;
                }
            }
        }

        if (index == -1) {
            return count;
        }


        for (int i = index; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int search_solution_2(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        int ans = 0;
        while (r >= 0 && nums[r] == t && r-- >= 0) ans++;
        return ans;
    }


    public int search_solution_3(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int search_solution_4(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}