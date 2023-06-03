package offer.dfs;

/*
[剑指 Offer 12. 矩阵中的路径](https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/)
给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



 */
public class O12 {

    public static void main(String[] args) {

        O12 o12 = new O12();

        char[][] x = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] aa = new char[][]{{'A', 'B'}, {'C', 'D'}};
        //o12.exist(x, "ABCCED");
        o12.exist(aa, "ABCD");

    }
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited){
        // 1. 下标越界 或者 board[i][j] 不等于 word.chatAt(k) 返回false
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k) || visited[i][j]){
            return false;
        }
        // 2. k的长度等于word的长度-1则说明有此路径
        if(k == word.length()-1) return true;
        // 3. 说明此事board[i][j]与 word.chatAt(k)相等，此事board[i][j]需要标记被访问
        visited[i][j] = true;
        // 4. 四边方向dfs
        boolean res = dfs(board, word, i+1, j, k+1, visited) ||
                dfs(board, word, i-1, j, k+1, visited) ||
                dfs(board, word, i, j+1, k+1, visited) ||
                dfs(board, word, i, j-1, k+1, visited);

        visited[i][j] = false;
        return res;
    }
}
