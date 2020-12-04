package com.jojo.libtest.sort;

import com.jojo.libtest.DataStructure;

import java.util.Arrays;

/**
 * @author JOJO
 * @date 2020/7/8
 * 插入排序
 * 将数组中所有元素依次与已排序部分比较，如果比已排序元素小则交换位置，直至所有元素都比较过为止。
 */
class InsertionSort extends DataStructure {
    public static void main(String[] args) {
        int[] in = generateRandomArrays();
        System.out.println("input " + printIntArray(in));
        System.out.println("output " + printIntArray(sort(in)));
    }

    public static int[] sort(int[] in) {
        if (in == null || in.length <= 1) {
            return in;
        }
        int[] out = in.clone();
        for (int i = 1, l = out.length; i < l; i++) {
            int temp = out[i];
            int j = i;
            while (j > 0 && temp < out[j - 1]) {
                out[j] = out[j - 1];
                j--;
            }
            if (j != i) {
                out[j] = temp;
            }
        }
        // 从左至右，依次增大
        return out;

    }
}
