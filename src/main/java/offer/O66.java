package offer;
import java.util.Arrays;

/*
[剑指 Offer 66. 构建乘积数组](https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/)

示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]

 */
public class O66 {
    public static void main(String[] args) {
        O66 o66 = new O66();
        System.out.println(Arrays.toString(o66.constructArr_solution_4(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] constructArr_solution_1(int[] a) {
        int[] ret = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int sum = 1;
            for (int j = 0; j < a.length; j++) {
                if(i == j) continue;
                sum *= a[j];
            }
            ret[i] = sum;
        }
        return ret;
    }

    public int[] constructArr_solution_2(int[] a) {
        if(a == null || a.length == 0 || a.length == 1) return a;

        int[] ret = new int[a.length];

        int[] left = new int[a.length];
        left[0] = 1;
        int[] right = new int[a.length];
        right[a.length - 1] = 1;

        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            ret[i] = left[i] * right[i];
        }

        return ret;
    }

    public int[] constructArr_solution_3(int[] a) {
        if(a == null || a.length == 0 || a.length == 1) return a;

        int[] ret = new int[a.length];
        ret[0] = 1;
        for (int i = 1; i < a.length; i++) {
            ret[i] = ret[i - 1] * a[i - 1];
        }

        int tmp = 1;
        for(int i = a.length - 2; i>=0; i--){
            tmp *= a[i+1];
            ret[i] *= tmp;
        }

        return ret;
    }

    public int[] constructArr_solution_4(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}