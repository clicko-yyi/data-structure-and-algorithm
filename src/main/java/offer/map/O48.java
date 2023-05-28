package offer.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
剑指 Offer 48. 最长不含重复字符的子字符串
https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class O48 {

    public static void main(String[] args) {
        O48 o48 = new O48();
        System.out.println(o48.lengthOfLongestSubstring_solution_3("abcabcbb"));
    }

    public int lengthOfLongestSubstring_solution_1(String s) {
        char[] charArray = s.toCharArray();
        int ret = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                if(set.contains(charArray[j])) {
                    break;
                }
                set.add(charArray[j]);
            }
            ret = Math.max(ret, set.size());
            set.clear();
        }
        return ret;
    }

    public int lengthOfLongestSubstring_solution_2(String s) {
        char[] charArray = s.toCharArray();
        int ret = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while(right < charArray.length) {
            while (set.contains(charArray[right])) {
                set.remove(charArray[left]);
                left++;
            }
            set.add(charArray[right]);
            right++;
            ret = Math.max(ret, set.size());
        }
        return ret;
    }

    public int lengthOfLongestSubstring_solution_3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        int ret = 0;
        while(right < charArray.length){
            if(map.containsKey(charArray[right])) {
                int recentPos = map.get(charArray[right]) + 1;
                if(recentPos >= left) {
                    left = recentPos;
                }
            }
            map.put(charArray[right], right);
            right++;
            ret = Math.max(ret, right - left);
        }
        return ret;
    }
}
