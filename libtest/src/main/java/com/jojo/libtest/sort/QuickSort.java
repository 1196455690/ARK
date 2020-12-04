package com.jojo.libtest.sort;

import com.jojo.libtest.DataStructure;

/**
 * @author JOJO
 * @date 2020/7/16
 * 快速排序
 */
class QuickSort extends DataStructure {
    public static void main(String[] args) {
        int[] in = generateRandomArrays();
        System.out.println(printIntArray(in) + " input >>>>>>>>");
        System.out.println(printIntArray(sort(in)) + " output <<<<<<<<");
    }

    public static int[] sort(int[] in) {
        if (in == null || in.length <= 1) {
            // 无需排序
            return in;
        }
        int[] out = in.clone();
        sort(out, 0, out.length - 1);
        return out;
    }

    public static void sort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
            System.out.println(printIntArray(arr));
        }
        swap(arr, low, left);
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }

}
