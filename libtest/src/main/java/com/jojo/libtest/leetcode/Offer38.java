package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JOJO
 * @date 2020/8/27
 * 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer38 extends DataStructure {
    class Solution {
        List<String> res = new LinkedList<>();
        char[] c;

        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }

        void dfs(int x) {
            if (x == c.length - 1) {
                res.add(String.valueOf(c));
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = x; i < c.length; i++) {
                if (set.contains(c[i])) {
                    continue;
                }
                set.add(c[i]);
                swap(i, x);
                dfs(x + 1);
                swap(i, x);
            }
        }

        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
    }
}
