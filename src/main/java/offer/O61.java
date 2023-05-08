package offer;
import java.util.Arrays;

/*
[面试题61. 扑克牌中的顺子](https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

示例1:
输入: [1,2,3,4,5]
输出: True


示例2:
输入: [0,0,1,2,5]
输出: True

 */
public class O61 {
    public static void main(String[] args) {
        O61 o58n1 = new O61();
        System.out.println(o58n1.isStraight_solution_1(new int[]{1,2,3,4,5}));
        System.out.println(o58n1.isStraight_solution_1(new int[]{0,0,1,2,5}));
    }

    public boolean isStraight_solution_1(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            } else {
                if(nums[i] == nums[i+1]) return false;
                zeroCount -= (nums[i+1] - nums[i] - 1);
            }
        }
        return zeroCount >= 0;
    }

    public boolean isStraight_solution_2(int[] nums) {
        Arrays.sort(nums);  // 从小到大排序
        int cha = 0;
        for(int i=nums.length -1; i>=0; i--){
            if(nums[i] == 0){
                continue;
            } else if(i > 0 && nums[i-1]!=0){  // 保证不越界，且0不参与相减
                int tmp_cha = nums[i] - nums[i-1];
                if(tmp_cha == 0){  // 如果相邻的两个数相等，则不是顺子
                    return false;
                }
                cha += tmp_cha;
            }
        }

        if(cha <= 4){  // 4是nums的长度减1
            return true;
        }
        else{
            return false;
        }
    }
}