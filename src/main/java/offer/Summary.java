package offer;

public class Summary {
    public static void main(String[] args) {

    }

    /*
    剑指 Offer 04. 二维数组中的查找
    {{1, 4, 7, 11, 15},
    {3,  6, 9, 16, 22},
    {10, 13, 14, 17, 24},
    {18, 21, 23, 26, 30}}
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean ret = false;

        int colIndex = 0, rowIndex = matrix.length - 1;

        /*
         rowIndex >= 0 && colIndex < matrix[0].length，中两个条件调换顺序不能改变
         colIndex < matrix[0].length && rowIndex >= 0
         */
        while (rowIndex >= 0 && colIndex < matrix[0].length) {
            if (target > matrix[rowIndex][colIndex]) {
                colIndex++;
            } else if (target < matrix[rowIndex][colIndex]) {
                rowIndex--;
            } else {
                ret = true;
                break;
            }
        }

        return ret;
    }

    /*
    剑指 Offer 05. 替换空格
    输入：s = "We are happy."
    输出："We%20are%20happy."
     */
    public String replaceSpace(String s) {
        int size = 0;
        char[] ret = new char[s.length() * 3];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                ret[size++] = '%';
                ret[size++] = '2';
                ret[size++] = '0';
            } else {
                ret[size++] = c;
            }
        }
        return new String(ret, 0, size);
    }

    /*
    剑指 Offer 11. 旋转数组的最小数字
    输入：numbers = [3,4,5,1,2]
    输出：1
    示例 2：

    输入：numbers = [2,2,2,0,1]
    输出：0
     */
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        int pivot;
        while (low < high) {
            pivot = low + ((high - low) >> 1);
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high = high - 1;
            }
        }
        return numbers[low];
    }

    /*
    剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    输入：nums = [1,2,3,4]
    输出：[1,3,2,4]
    注：[3,1,2,4] 也是正确的答案之一。
    */
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


    /*
    剑指 Offer 17. 打印从1到最大的n位数
    输入: n = 1
    输出: [1,2,3,4,5,6,7,8,9] 10,11,12,13,14,15,16,17,18,19
     */
    int[] res;
    int count = 0;
    public int[] printNumbers(int n) {
        res = new int[(int) (Math.pow(10, n) - 1)];
        for (int limit = 1; limit <= n; limit++) {
            for (char c = '1'; c <= '9'; c++) {
                char[] chars = new char[limit];
                chars[0] = c;
                dfs(chars, 1, limit);
            }
        }
        return res;
    }
    private void dfs(char[] chars, int level, int limit){
        if (level == limit) {
            res[count++] = Integer.valueOf(new String(chars));
            return;

        }

        for(char i = '0'; i <= '9'; i++){
            chars[level] = i;
            dfs(chars, level + 1, limit);
        }

    }



}