package com.jojo.libtest.sort;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/7/8
 * 冒泡排序
 * 遍历数组，小的数值往上浮
 */
class BubbleSort extends DataStructure {
    public static void main(String[] args) {
        int[] in = generateRandomArrays();
        System.out.println("input " + printIntArray(in));
        System.out.println("output " + printIntArray(sort(in)));
    }

    /**
     * 从左至右，依次增大
     */
    public static int[] sort(int[] in) {
        if (in == null || in.length <= 1) {
            return in;
        }
        int[] out = in.clone();
        for (int i = 0, l = out.length - 1; i < l; i++) {
            // 已完成排序的标志
            boolean isSort = true;
            for (int j = 0, temp; j < l - i; j++) {
                // 交换比较值的位置
                if (out[j] > out[j + 1]) {
                    temp = out[j + 1];
                    out[j + 1] = out[j];
                    out[j] = temp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
        return out;
    }
}
