package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JOJO
 * @date 2020/8/5
 * 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * --[9,20],
 * --[15,7]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer32_2 extends DataStructure {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0, size = queue.size(); i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        continue;
                    }
                    temp.add(node.val);
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
