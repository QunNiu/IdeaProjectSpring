package cn.edu.ctgu.sort1;

import java.util.Arrays;

/**
 * @author NiuQun
 * @date 2021/10/15
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 4, 6, 5, 4, 3, 2, 1, 10};
        // bubbleSort(arr);
        // selectSort(arr);temp[3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //temp[2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0]
        //temp[1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //temp[1, 2, 3, 4, 10, 0, 0, 0, 0, 0, 0]
        //tem
        // insertSort(arr);
        // quickSort(arr, 0, arr.length-1);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        // i排序的趟数
        boolean flag = true;
        int temp;
        for (int i = 1; i <= arr.length-1; i++) {
            for (int j = 0; j <= arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        int indexOfMinValue;
        int temp;
        // i表示排序的趟数
        for (int i = 1; i <= arr.length-1; i++) {
             indexOfMinValue = i-1;
            for (int j = i; j <= arr.length-1; j++) {
                if (arr[indexOfMinValue] > arr[j]) {
                    indexOfMinValue = j;
                }
            }
            temp = arr[i-1];
            arr[i-1] = arr[indexOfMinValue];
            arr[indexOfMinValue] = temp;
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i <= arr.length-1; i++) {
            int current = arr[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int pivot = arr[left];

        while (left < right) {
            // 在pivot右边找一个小于pivot的数字
            // 有可能pivot右边的数字全部大于pivot， 那么这个while循环会一直进行，直到right--，
            // 即right=-1时出现索引越界，所以要加left < right
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            arr[left] = arr[right];
            // 在pivot左边找一个大于pivot的数字
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }

        // 此时left==right
        arr[left] = pivot;
        quickSort(arr, leftIndex, left-1);
        quickSort(arr, right+1, rightIndex);
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        // 提供额外数组
        int[] temp = new int[arr.length];
        divide(arr, 0, arr.length-1, temp);
    }
    // 分解数组
    public static void divide(int[] arr, int leftIndex, int rightIndex, int[] temp) {
        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex)/2;
            divide(arr, leftIndex, midIndex, temp);
            divide(arr, midIndex+1, rightIndex, temp);
            merge(arr, leftIndex, midIndex, rightIndex, temp);
        }
    }
    // 排序并合并数组
    public static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex, int[] temp) {
        int i = leftIndex;
        int j = midIndex+1;
        int k = 0;
        while (i <= midIndex && j <= rightIndex) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= midIndex) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= rightIndex) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        int m = leftIndex;
        int n = 0;
        while (m <= rightIndex) {
            arr[m] = temp[n];
            m++;
            n++;
        }

        System.out.println("temp" + Arrays.toString(temp));
        Arrays.fill(temp, 0);
    }

}
