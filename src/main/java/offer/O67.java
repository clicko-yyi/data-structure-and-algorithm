package offer;

import java.util.HashMap;
import java.util.Map;
/*
[面试题67. 把字符串转换成整数](https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)
示例1:

输入: "42"
输出: 42
示例2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
 */
public class O67 {

    public static void main(String[] args) {
        O67 o67 = new O67();
        System.out.println(o67.strToInt_solution_3("4193 with words"));
    }
    public int strToInt_solution_1(String str) {
        str = str.trim();
        boolean isPositive = true;
        boolean isValid = true;
        int ret = 0;
        boolean flag = false;
        char c = str.charAt(0);
        int bdy = Integer.MAX_VALUE / 10;
        if (Character.isDigit(c)) {
            ret = c - '0';
            flag = true;
        } else if (c == '+') {
            isPositive = true;
        } else if (c == '-') {
            isPositive = false;
        } else {
            isValid = false;
        }

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                if (ret > bdy || ret == bdy && ch > '7') {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ret = ret * 10 + (ch - '0');
                flag = true;
            } else {
                if (flag) {
                    break;
                } else {
                    isValid = false;
                    break;
                }
            }

        }
        return isValid ? isPositive ? ret : -ret : 0;
    }
    public int strToInt_solution_2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public int strToInt_solution_3(String str) {
        if(str == null || str.length() == 0) return 0;
        int sign = 1;
        int ans = 0;
        int bndry = Integer.MAX_VALUE / 10;
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == ' '){
                i++;
            }else{
                break;
            }
        }
        if(i >= str.length()) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for (int j = i; j < str.length(); j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(ans > bndry || ans == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (str.charAt(j) - '0');
        }
        return sign * ans;
    }
}
