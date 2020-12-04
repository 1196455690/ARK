package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/8/3
 * 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 * ------3
 * -----/ \
 * ----4   5
 * ---/ \
 * --1   2
 *
 * 给定的树 B：
 * ----4 
 * ---/
 * --1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer26 extends DataStructure {
    /**
     * 查找匹配子节点N(b)的子节点N(a)，校验N(a)与N(b)左右分支是否相同
     */
    class Solution {
        /**
         * 匹配子节点
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // A｜B为null时，return false
            // A&B完全匹配 ｜ A.left&B子节点匹配 | A.right&B子节点匹配时，return true
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        /**
         * 匹配分支
         */
        public boolean recur(TreeNode A, TreeNode B) {
            if (B == null) {
                // 匹配结束
                return true;
            }
            if (A == null || A.val != B.val) {
                // 遍历完A，仍未找到匹配的B ｜ A&B当前节点不同，必定不匹配
                return false;
            }
            // 递归匹配AB分支
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }
}
