package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/5/18
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer06 extends DataStructure {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 2};
        System.out.println("Input " + ints2String(ints));
        System.out.println("Output " + ints2String(reversePrint(input(ints))));
    }

    public static int[] reversePrint(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while (currNode != null) {
            len++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while (currNode != null) {
            result[len - 1] = currNode.val;
            len--;
            currNode = currNode.next;
        }
        return result;
    }

    private static ListNode input(int... ints) {
        if (ints.length <= 0) {
            return null;
        }
        int i = ints.length - 1;
        ListNode listNode = new ListNode(ints[i]);
        ListNode currentNode;
        while (i > 0) {
            i--;
            currentNode = new ListNode(ints[i]);
            currentNode.next = listNode;
            listNode = currentNode;
        }
        return listNode;
    }

    private static String ints2String(int[] ints) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, length = ints.length; i < length; i++) {
            if (i == 0) {
                builder.append("[ ");
            }
            builder.append(ints[i]);
            if (i == length - 1) {
                builder.append(" ]");
            } else {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
