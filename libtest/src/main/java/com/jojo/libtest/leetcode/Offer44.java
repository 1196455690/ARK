package com.jojo.libtest.leetcode;

/**
 * @author zhoupeng
 * @date 2020/11/5
 * 剑指 Offer 44. 数字序列中某一位的数字
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 *
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 *
 * 限制：
 * 0 <= n < 2^31
 * 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer44 {
    class Solution {
        public int findNthDigit(int n) {
            // n所在数字的位数，e.g. num == 10，digit == 2，n == 100，digit == 3
            int digit = 1;
            // digit位数的起始数字，e.g. 1，10，100
            long start = 1;
            // 数位数量，e.g. digit == 2，count == 90
            long count = 9;

            while (n > count) {
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }

            // n所在的数字
            long num = start + (n - 1) / digit;
            return Long.toString(num).charAt((n - 1) % digit) - '0';
        }
    }
}
