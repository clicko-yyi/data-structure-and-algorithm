package offer.map;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
剑指 Offer 50. 第一个只出现一次的字符
https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例 1:
输入：s = "abaccdeff"
输出：'b'
 */
public class O50 {

    public static void main(String[] args) {
        O50 o50 = new O50();
        System.out.println(o50.firstUniqChar_solution_3("abaccdeff"));
    }

    public char firstUniqChar_solution_1(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            boolean flag = true;
            for (int j = 0; j < charArray.length; j++) {
                if (i != j && charArray[i] == charArray[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return charArray[i];
            }
        }
        return ' ';
    }

    public char firstUniqChar_solution_2(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public char firstUniqChar_solution_3(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : arr) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar_solution_4(String s) {
        int n = s.length();
        if (n == 0) return ' ';
        int first, last, ans = 50001;
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            first = s.indexOf(ch);
            if (first != -1) {
                last = s.lastIndexOf(ch);
                if (first == last) {
                    ans = ans > first ? first : ans;
                }
            }
        }
        return ans == 50001 ? ' ' : s.charAt(ans);
    }
}
