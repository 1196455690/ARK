package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/8/3
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer24 extends DataStructure {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = null, pre = head, node;
            while (pre != null) {
                node = pre.next;
                pre.next = cur;
                cur = pre;
                pre = node;
            }
            return cur;
        }
    }
}
