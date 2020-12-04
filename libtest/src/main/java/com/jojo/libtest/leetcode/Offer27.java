package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/8/4
 * 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 * -----4
 * ---/   \
 * --2     7
 * -/ \   / \
 * 1   3 6   9
 *
 * 镜像输出：
 * -----4
 * ---/   \
 * --7     2
 * -/ \   / \
 * 9   6 3   1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer27 extends DataStructure {

    /*class Solution {
        public TreeNode mirrorTree(TreeNode root) {

        }
    }*/

    class Solution1 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 递归交换左右节点
            TreeNode left = mirrorTree(root.right);
            TreeNode right = mirrorTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
