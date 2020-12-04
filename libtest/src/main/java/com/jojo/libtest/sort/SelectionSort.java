package com.jojo.libtest.sort;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/7/8
 * 选择排序
 * 遍历未排序部分，寻找最小值与当前比较值交换位置，直至排序完成
 */
class SelectionSort extends DataStructure {
    public static void main(String[] args) {
        int[] in = generateRandomArrays();
        System.out.println("input " + printIntArray(in));
        // 从左至右，依次增大
        System.out.println("output " + printIntArray(sort(in)));
    }

    public static int[] sort(int[] in) {
        if (in == null || in.length <= 1) {
            return in;
        }
        int[] out = in.clone();
        for (int i = 0, l = out.length; i < l; i++) {
            // 从左至右寻找最小值
            int min = i;
            for (int j = i + 1; j < l; j++) {
                if (out[j] < out[min]) {
                    min = j;
                }
            }
            // 交换当前比较值与最小值的位置
            int temp = out[i];
            out[i] = out[min];
            out[min] = temp;
        }
        return out;
    }
}
