package com.jojo.libtest.leetcode;

import com.jojo.libtest.DataStructure;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JOJO
 * @date 2020/5/19
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 * -----3
 * ----/ \
 * ---9  20
 * -----/  \
 * ----15  7
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer07 extends DataStructure {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] midOrder = new int[]{9, 3, 15, 20, 7};
        System.out.println("preOrder " + printIntArray(preOrder));
        System.out.println("midOrder " + printIntArray(midOrder));
        buildTree(preOrder, midOrder);
    }

    @Nullable
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1,
                inorder, 0, length - 1, indexMap);
    }

    @Nullable
    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                                     int[] inorder, int inorderStart, int inorderEnd,
                                     Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart != preorderEnd) {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1,
                    preorderStart + leftNodes, inorder, inorderStart,
                    rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(
                    preorder, preorderEnd - rightNodes + 1,
                    preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
        }
        return root;
    }

}
