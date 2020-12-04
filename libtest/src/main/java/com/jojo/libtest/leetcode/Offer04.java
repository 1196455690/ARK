package com.jojo.libtest.leetcode;

import java.util.Arrays;

/**
 * @author JOJO
 * @date 2020/5/14
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04 {
    public static void main(String[] args) {

        /*int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/
//        int[][] matrix = new int[][]{{5}, {6}};
//        int[][] matrix = new int[][]{{}};
        int[][] matrix = new int[][]{};
        int target = 6;
        System.out.println("Matrix \n" + Arrays.toString(matrix));
        System.out.println("Target => " + target);
        System.out.println("Output => " + findNumberIn2DArray(matrix, target));
    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[n - 1].length;
        if (m == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            int t = ints[m - 1];
            // 取当前行末尾与target比较
            if (target == t) {
                return true;
            }
            if (target > t) {
                continue;
            }
            for (int j : ints) {
                if (target == j) {
                    return true;
                }
            }
        }
        return false;
    }
}
