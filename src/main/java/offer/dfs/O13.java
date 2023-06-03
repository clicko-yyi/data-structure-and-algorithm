package offer.dfs;

/*
[面试题13. 机器人的运动范围](https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
 */
public class O13 {
    public static void main(String[] args) {
        maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }

    public int movingCount(int m, int n, int k) {
        return 1;
    }


    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        for(int j = 1;j<nums.length;j++){
            if(dp[j-1]>0){
                dp[j] = dp[j-1]+nums[j];
            }else{
                dp[j] = nums[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<dp.length;i++){
            if(dp[i]>max)
                max = dp[i];
        }
        return max;
    }



}
