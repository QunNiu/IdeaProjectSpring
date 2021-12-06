package cn.edu.ctgu.sort;

import java.util.Arrays;

/**
 * @author NiuQun
 * @date 2021/10/15
 */
public class SortTest {
    public static void main(String[] args) {
        //int[] arr = {49, 38, 13, 49, 97, 49, 49, 13, 27};
        int[] arr = {9, 8, 6, 6,  5, 4, 3, 2};
        //System.out.println(Arrays.toString(bubbleSort(arr)));
        //System.out.println(Arrays.toString(selectSort(arr)));
        //System.out.println(Arrays.toString(insertSort(arr)));
        /*
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
         */
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序是原地排序，不需要额外的空间！而且是稳定排序的算法，时间的复杂度最好为O(n),最坏为O(n2),平均为O(n2)。
     * 冒泡排序是原地排序，不需要额外的空间！而且是稳定排序的算法，时间的复杂度最好为O(n),最坏为O(n2),平均为O(n2)。
     * 选择排序是原地排序，不需要额外的空间！但是是不稳定排序的算法！时间的复杂度最好,最坏为,平均都为O(n2)
     */
    /**
     * 冒泡排序
     * 最好时间复杂度：O(n), 本来就是有序的，一趟冒泡排序就可以完成，比较次数为n-1且无移动
     * 最坏时间复杂度：O(n*n), 逆序，要排n-1趟， 第i趟分别排n-i次， 则 ((n-1) * ((n-1) + (1))) / 2 = n(n-1)/2
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * 稳定排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        // i：比较的趟数
        for (int i = 1; i <= arr.length-1 ; i++) {
            // 假设当下待排序的部分是有序的
            boolean flag = true;
            int temp;
            // j：第i趟中，第j个数和第j+1个数比较大小
            // 第i=1趟，j从0到arr.length-2,因为最后一次是arr[arr.length-2]和arr[arr.length-1]比较
            // 第i=2趟，j从0到arr.length-3,因为最后一次是arr[arr.length-3]和arr[arr.length-2]比较
            // ......
            for (int j = 0; j <= arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 当此次排序过程中出现交换时，代表待排列部分并不是有序的
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            // 如果此趟排序发现待排序部分已经有序，则不用再进行后续的排序
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 最好时间复杂度：O(n*n)
     * 最坏时间复杂度：O(n*n)     (n-1)((n-1) + 1 )/2 = (n-1)n/2
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * 不稳定排序：比如5 8 5 2 9， 第一趟中，第一个5会和2交换
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        // i：代表当前是第几趟
        int indexOfMinValue;
        int temp;

        for (int i = 1; i <= arr.length-1; i++) {
            indexOfMinValue = i-1;
            // j：初始值代表从数组的哪一个索引位置开始查找最小值,用min记住当前最小值的索引
            for (int j = i; j <= arr.length-1 ; j++) {
                if (arr[indexOfMinValue] > arr[j]) {
                    indexOfMinValue = j;
                }
            }

            temp = arr[i-1];
            arr[i-1] = arr[indexOfMinValue];
            arr[indexOfMinValue] = temp;

        }
        return arr;
    }

    /**
     * 插入排序
     * 最好时间复杂度：O(n) 本身是有序的，此时只需要比较n-1次
     * 最坏时间复杂度：O(n*n) 本身是逆序的，此时需要比较(n-1)(1 + n-1)/2 = (n-1)*n/2
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * 稳定排序：
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i <= arr.length-1; i++){
            // 我们需要把索引为i的元素插入到前边有序集合的合适位置
            // 该过程中需要移动前边有序数组的大量元素
            // 用current临时保存此次需要插入的数据
            int current = arr[i];

            int preIndex = i-1;
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
                arr[preIndex+1] = current;
        }
        return arr;
    }

    /**
     * 快速排序-递归法
     * 最好时间复杂度：O(nlogn)，每趟排序结束后，每次划分使得两个数组的长度大致相等，一次递归需要比较n次，一共需要递归logn次
     * 最坏时间复杂度：O(n*n)，待排序的序列为正序或者逆序，每次划分只得到一个比上一次划分少一个记录的子序列，注意另一个为空。如果递归树画出来，它就是一棵斜树。
     *
     * 最好空间复杂度：O(logn),由于需要递归logn次
     * 最坏空间复杂度：O(n)，需要进行n‐1递归调用， 待排序的序列为正序或者逆序，每次划分只得到一个比上一次划分少一个记录的子序列，注意另一个为空。如果递归树画出来，它就是一棵斜树。
     *
     * 平均时间复杂度：O(nlogn)
     * 平均空间复杂度：O(logn)
     * 不稳定，比如：4，3，3 那么第二个三会跳到4前边
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        // 递归出口
        if (leftIndex >= rightIndex) {
            return;
        }
        // 每次把最左边的一个数作为基准，我们希望基准左边的数都小于基准，基准右边的数都大于基准
        int pivot = arr[leftIndex];
        int left = leftIndex;
        int right = rightIndex;

        // 如果left >= right说明pivot左边的值都小于他，右边的值都大于他
        while (left < right) {
            // 在索引右边查找一个小于pivot的数字，将其赋值给左边索引位置
            while (pivot <= arr[right] && left < right) {
                // 在pivot右侧找一个比pivot小的值
                right--;
            }
            // 即使pivot右边的值全都大于pivot，那么最后right会等于left
            arr[left] = arr[right];

            // 即使pivot左边的值全都小于pivot，那么最后left会等于right
            while (arr[left] <= pivot && left < right) {
                // 在pivot左侧找一个比pivot小的值
                left++;
            }
            arr[right] = arr[left];
        }
        // 循环结束时，一定有left == right
        arr[left] = pivot;
        quickSort(arr, leftIndex, left-1);
        quickSort(arr, right+1, rightIndex);
    }


    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        // 归并排序需要额外的空间
        int[] temp = new int[arr.length];
        divide(arr, 0, arr.length-1, temp);
    }
    public static void divide(int[] arr, int leftIndex, int rightIndex, int[] temp) {
        // 每个数组只要不是leftIndex >= rightIndex，就可以继续划分，
        if (leftIndex < rightIndex) {
            // 中间索引
            int midIndex = (leftIndex + rightIndex)/2;
            // 左递归分解
            divide(arr, leftIndex, midIndex, temp);
            // 右递归分级
            divide(arr, midIndex+1, rightIndex, temp);

            // 合并
            merge(arr, leftIndex, midIndex, rightIndex, temp);
        }
    }
    /**
     * 归并排序的 排序以及合并部分
     * 将数组arr中的两个有序部分[leftIndex, midIndex] 和 [midIndex+1, rightIndex],
     * 借助temp数组合并成一个有序的[leftIndex, rightIndex]
     * @param temp 中转数组
     */
    public static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex, int[] temp) {
        // 左边有序数组的初始索引, [leftIndex, midIndex]
        int i = leftIndex;
        // 右边有序数组的初始索引, [midIndex+1, rightIndex]
        int j = midIndex+1;

        // 指向temp数组的当前索引
        int k = 0;

        // 1.将两个有序数组合并为第三个有序数组
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
        // 2.如果某个数组有剩余，则直接将剩余数据的填充到第三数组
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

        // 3.将temp数组的[0, rightIndex-leftIndex]元素拷贝到，arr数组的[leftIndex, rightIndex]中
        int m = leftIndex;
        int n = 0;
        while (m <= rightIndex) {
            arr[m] = temp[n];
            m++;
            n++;
        }
    }
}
