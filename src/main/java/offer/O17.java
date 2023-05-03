package offer;

public class O17 {
    public static void main(String[] args) {
        O17 o17 = new O17();
        o17.printNumbers(3);
    }
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
