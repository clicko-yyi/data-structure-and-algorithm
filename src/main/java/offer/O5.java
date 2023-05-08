package offer;
/*
[剑指 Offer 05. 替换空格](https://leetcode.cn/problems/ti-huan-kong-ge-lcof/)

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

 */
public class O5 {
    public static void main(String[] args) {
        O5 o5 = new O5();
        System.out.println(o5.replaceSpace_solution_1("We are happy."));
    }

    public String replaceSpace_solution_1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public String replaceSpace_solution_2(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}