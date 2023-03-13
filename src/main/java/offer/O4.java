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
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(target == matrix[i][j]){
                return true;
            }
            if(target < matrix[i][j]){
                i--;
            }else{ // greater or less, no equal
                j++;
            }
        }
        return false;
    }
}