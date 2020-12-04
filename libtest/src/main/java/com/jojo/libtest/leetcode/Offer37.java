package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JOJO
 * @date 2020/8/25
 * 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 * 你可以将以下二叉树：
 * --1
 * -/ \
 * 2   3
 * ---/ \
 * --4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Offer37 extends DataStructure {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            StringBuilder stringBuilder = new StringBuilder("[");
            while (!list.isEmpty()) {
                TreeNode node = list.poll();
                if (node != null) {
                    stringBuilder.append(node.val).append(",");
                    list.add(node.left);
                    list.add(node.right);
                } else {
                    stringBuilder.append("null,");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(root);
            int i = 1;
            while (!list.isEmpty()) {
                TreeNode node = list.poll();
                if (!"null".equals(vals[i])) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    list.add(node.left);
                }
                i++;
                if (!"null".equals(vals[i])) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    list.add(node.right);
                }
                i++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
