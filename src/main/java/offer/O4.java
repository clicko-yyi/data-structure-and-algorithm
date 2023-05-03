package offer;

public class O4 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        O4 test = new O4();
        System.out.println(test.findNumberIn2DArray(matrix, 17));
        System.out.println(test.findNumberIn2DArray(matrix, 999));
    }

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
}