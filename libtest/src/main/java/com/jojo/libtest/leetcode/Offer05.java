package com.jojo.libtest.leetcode;

/**
 * @author JOJO
 * @date 2020/5/14
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer05 {

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println("Output " + replaceSpace(str));
    }

    /*public static String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0, length = s.length(); i < length; i++) {
            if (' ' == s.charAt(i)) {
                str.append("%20");
            } else {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }*/

    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (' ' == c) {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
