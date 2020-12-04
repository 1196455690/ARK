package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JOJO
 * @date 2020/8/14
 * 从上到下打印二叉树 III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * ----3
 * ---/ \
 * --9  20
 * ----/  \
 * ---15   7
 *
 * 返回其层次遍历结果：
 * [
 * --[3],
 * --[20,9],
 * --[15,7]
 * ]
 *  
 * 提示：
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer32_3 extends DataStructure {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                LinkedList<Integer> temp = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    // 取出队首node
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    if (res.size() % 2 == 0) {
                        // 偶数倒序
                        temp.addLast(node.val);
                    } else {
                        // 奇数正序
                        temp.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(temp);
            }
            return res;
        }
    }
}
