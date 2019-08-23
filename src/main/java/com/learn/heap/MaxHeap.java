package com.learn.heap;

import java.util.Arrays;

/**
 * 最大堆(简易版)
 */
public class MaxHeap {

    public Integer[] values = new Integer[16];
    public int size;

    /**
     * 添加一个元素到堆中
     *
     * @param item
     */
    public void push(int item) {
        if (size == 0) {
            size++;
            values[0] = item;
            return;
        }
        int k = size;
        size++;
        shiftUp(k, item);
    }

    /**
     * 上浮
     *
     * @param k
     * @param item
     */
    private void shiftUp(int k, int item) {
        for (; ; ) {
            int parentIndex = (k - 1) / 2;
            if (item < values[parentIndex]) {
                break;
            }
            values[k] = values[parentIndex];
            k = parentIndex;
            if (k == 0) {
                break;
            }
        }
        values[k] = item;
    }

    /**
     * 从堆中获取第一个元素并删除
     *
     * @return
     */
    public int poll() {
        if (size == 0) {
            return -1;
        }
        size--;
        int value = values[0];
        int item = values[size];
        values[size] = null;
        shiftDown(0, item);
        return value;
    }

    /**
     * 下沉
     *
     * @param k
     * @param item
     */
    private void shiftDown(int k, int item) {
        for (; ; ) {
            int leftIndex = 2 * k + 1;
            int rightIndex = leftIndex + 1;
            if (values[leftIndex] == null) {
                break;
            }
            int c = values[leftIndex];
            int childIndex = leftIndex;
            if (values[rightIndex] != null && values[rightIndex] > values[leftIndex]) {
                c = values[rightIndex];
                childIndex = rightIndex;
            }
            if (item > c) {
                break;
            }
            values[k] = c;
            k = childIndex;
        }
        values[k] = item;
    }

    public static void main(String[] args) {
        MaxHeap miniHeap = new MaxHeap();
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(4);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(2);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(7);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(9);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(1);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(5);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(10);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(3);
        System.out.println(Arrays.toString(miniHeap.values));
        miniHeap.push(2);
        System.out.println(Arrays.toString(miniHeap.values));

        for (int i = 0; i < 9; i++) {
            System.out.println(miniHeap.poll());
        }
    }

}
