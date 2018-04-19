package sort;

import org.junit.Test;

/**
 * 插入排序
 *
 * @author exphuhong
 * @since 19:51 2018/4/19
 */
public class InsertSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 优化之后的插入排序
     */
    public static void optimizeSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     *
     * 测试普通的插入排序
     */
    @Test
    public void test1() {
        int[] arr = {10, 5, 11, 15, 1, 3, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(i<arr.length-1?",":"");
        }
    }

    /**
     * 测试优化之后的插入排序
     */
    @Test
    public void test2() {
        int[] arr = {10, 5, 11, 15, 1, 3, 8};
        optimizeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(i<arr.length-1?",":"");
        }
    }
}
