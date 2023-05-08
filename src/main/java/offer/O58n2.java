package offer;

/*
[剑指 Offer 58 - II. 左旋转字符串](https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

示例 1：
输入: s = "abcdefg", k = 2
输出:"cdefgab"

示例 2：
输入: s = "lrloseumgh", k = 6
输出:"umghlrlose"

 */
public class O58n2 {
    public static void main(String[] args) {
        O58n2 o58n1 = new O58n2();
        System.out.println(o58n1.reverseLeftWords_solution_3("abcdefg", 2));
        System.out.println(o58n1.reverseLeftWords_solution_3("lrloseumgh", 6));
    }

    public String reverseLeftWords_solution_1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords_solution_2(String s, int n) {
        char[] ret = new char[s.length()];
        for (int i = 0, index = n; i < s.length(); i++, index = (index+1)%s.length()) {
            ret[i] = s.charAt(index);
        }
        return new String(ret);
    }

    public String reverseLeftWords_solution_3(String s, int n) {
        char[] ch = s.toCharArray();
        reverse(ch,0,ch.length-1);
        reverse(ch,0,ch.length-1-n);
        reverse(ch,ch.length-n,ch.length-1);
        return new String(ch);
    }

    public void reverse(char[] arr,int start,int end){
        char tem;
        while (end > start){
            tem = arr[start];
            arr[start] = arr[end];
            arr[end] = tem;
            start++;
            end--;
        }
    }

}
