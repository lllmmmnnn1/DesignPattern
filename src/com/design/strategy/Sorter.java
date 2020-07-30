package com.design.strategy;

public class Sorter<T> {
    //此时的sorter可以比较int类型的大小，但是如果换成double，long类型
    //那么又需要在实现一次，或者比较一个对象的属性等等，都需要重复的再写一次
    /*public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }*/

    /**
     *这里已经能在不动用sorter方法的情况下，自己创建对象，实现compareTo方法来
     * 比较某一个属性的大小，但是如果此时再想对比cat的height时，就又要重写compareTo方法
     */
    /*public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }*/

    /**
     *所需要的对象，自己定义比较的方法策略，实现Comparator接口进行比较，所有的比较
     * 都只需要添加策略即可
     */
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
