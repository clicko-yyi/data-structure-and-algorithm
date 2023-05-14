package offer.queue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/*
[剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

 */
public class O59n1 {

    public static void main(String[] args) {
        O59n1 o59n1 = new O59n1();
        o59n1.maxSlidingWindow_solution_4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
    public int[] maxSlidingWindow_solution_1(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }

    public int[] maxSlidingWindow_solution_2(int[] nums, int k) {
        // 第三次提交，对第二种暴力遍历窗口的方法，小加速，成功（用时+内存：97%，72%）
        // 加速原理：每次滑动窗口向右移动时，判断
        // a. 新加入的值 是否比上一个窗口最大值大，若是，则直接返回 新加入的值
        // b. 待移除的值 是否比上一个窗口最大值小，若是，则返回 上一窗口最大值
        if(k==0)return new int[0];
        int ans[] = new int[nums.length-k+1];   // 记录每一窗口的最大值
        for(int i=0;i+k-1<nums.length;i++){
            if(i>0 && nums[i+k-1]>ans[i-1])ans[i] = nums[i+k-1];    // 新值比上一窗口最大值大，返回 新值
            else if(i>0 && nums[i-1]<ans[i-1])ans[i] = ans[i-1];    // 旧值比上一窗口最大值小，返回 上一窗口最大值
            else{   // 遍历滑动窗口，找到最大值
                int max = Integer.MAX_VALUE+1;
                for(int j=i;j<i+k;j++){
                    max = Math.max(max,nums[j]);
                    ans[i] = max;
                }
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow_solution_3(int[] nums, int k) {
        int []res = new int[nums.length-k+1];
        if(k > nums.length || k < 1 || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1); /* 大顶堆 */
        for(int i=0;i<k;i++) {
            heap.add(nums[i]);
        }
        res[0] = heap.peek();
        for(int i=0,j=i+k;j<nums.length;i++,j++) { /* 维护一个大小为 size 的大顶堆 */
            heap.remove(nums[i]);
            heap.add(nums[j]);
            res[i + 1] = heap.peek();
        }
        return res;
    }

    public int[] maxSlidingWindow_solution_4(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }

}
