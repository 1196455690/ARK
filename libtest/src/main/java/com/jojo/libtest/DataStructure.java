package com.jojo.libtest;

import java.util.Random;

/**
 * @author JOJO
 * @date 2020/5/14
 */
@SuppressWarnings("FinalStaticMethod")
public abstract class DataStructure {

    public static final class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static final class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static final int[] generateRandomArrays() {
        return generateRandomArrays(15, 20);
    }

    public static final int[] generateRandomArrays(int size, int max) {
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = new Random().nextInt(max);
        }
        return arrays;
    }

    public static final String printIntArray(int[] ints) {
        if (ints == null) {
            return null;
        }
        int length = ints.length;
        if (length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                builder.append("[");
            }
            builder.append(ints[i]);
            if (i == length - 1) {
                builder.append("]");
            } else {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /*public static final String printListNode(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(listNode.val);
        while (listNode.next != null) {
            builder.append(" -> ").append(listNode.next.val);
        }
        return builder.toString();
    }*/

    /*public static final ListNode intArray2ListNode(int[] ints) {
        return null;
    }*/

    public static final void swap(int[] array, int indexA, int indexB) {
        final int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

}
