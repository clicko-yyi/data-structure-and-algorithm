package offer;

import java.util.ArrayList;
import java.util.List;

/*
[剑指 Offer 58 - I. 翻转单词顺序](https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/)
示例 1：
输入: "the sky is blue"
输出:"blue is sky the"

示例 2：
输入: " hello world! "
输出:"world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good  example"
输出:"example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class O58n1 {
    public static void main(String[] args) {
        O58n1 o58n1 = new O58n1();
        System.out.println(o58n1.reverseWords_solution_2("the sky is blue"));
        System.out.println(o58n1.reverseWords_solution_2(" hello world! "));
        System.out.println(o58n1.reverseWords_solution_2("a good  example"));
    }

    public String reverseWords_solution_1(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' '){
                if(tmp.length() > 0){
                    list.add(reverse(tmp.toString()));
                    tmp = new StringBuilder();
                }else{
                    continue;
                }
            }else{
                tmp.append(s.charAt(i));
            }
        }
        if(tmp.length() > 0) list.add(reverse(tmp.toString()));
        return String.join(" ", list);
    }

    private String reverse(String s){
        char[] ret = new char[s.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = s.charAt(s.length() - i - 1);
        }
        return new String(ret);
    }

    public String reverseWords_solution_2(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            while(i>=0 && s.charAt(i) != ' ') i--;
            stringBuilder.append(s, i+1, j+1).append(" ");
            while(i>=0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return stringBuilder.toString();
    }
}