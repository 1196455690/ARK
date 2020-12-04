package com.jojo.libtest.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JOJO
 * @date 2020/7/31
 * 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、
 * "3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer20 {
    class Solution {
        public boolean isNumber(String s) {
            Map[] states = {
                    new HashMap<Character, Integer>() {{
                        // 0.
                        put(' ', 0);
                        put('s', 1);
                        put('d', 2);
                        put('.', 4);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 1.
                        put('d', 2);
                        put('.', 4);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 2.
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 3.
                        put('d', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 4.
                        put('d', 3);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 5.
                        put('s', 6);
                        put('d', 7);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 6.
                        put('d', 7);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 7.
                        put('d', 7);
                        put(' ', 8);
                    }},
                    new HashMap<Character, Integer>() {{
                        // 8.
                        put(' ', 8);
                    }}
            };
            int p = 0;
            char t;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    t = 'd';
                } else if (c == '+' || c == '-') {
                    t = 's';
                } else if (c == '.' || c == 'e' || c == 'E' || c == ' ') {
                    t = c;
                } else {
                    t = '?';
                }
                if (!states[p].containsKey(t)) {
                    return false;
                }
                p = (int) states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }

    class Solution1 {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            //标记是否遇到相应情况
            boolean numSeen = false;
            boolean dotSeen = false;
            boolean eSeen = false;
            char[] str = s.trim().toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] >= '0' && str[i] <= '9') {
                    numSeen = true;
                } else if (str[i] == '.') {
                    //.之前不能出现.或者e
                    if (dotSeen || eSeen) {
                        return false;
                    }
                    dotSeen = true;
                } else if (str[i] == 'e' || str[i] == 'E') {
                    //e之前不能出现e，必须出现数
                    if (eSeen || !numSeen) {
                        return false;
                    }
                    eSeen = true;
                    numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
                } else if (str[i] == '-' || str[i] == '+') {
                    //+-出现在0位置或者e/E的后面第一个位置才是合法的
                    if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                        return false;
                    }
                } else {//其他不合法字符
                    return false;
                }
            }
            return numSeen;
        }
    }
}
