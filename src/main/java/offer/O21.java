package offer;

public class O21 {
    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int oddIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 1){
                int tmp = nums[i];
                nums[i] = nums[oddIndex];
                nums[oddIndex] = tmp;
                oddIndex++;
            }
        }

        return nums;
    }
}
