package sort;

/**
 * 冒泡排序
 *@author exphuhong
 *@since  19:35 2018/4/19
 *
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = {10, 5, 11, 15, 1, 3, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(i<arr.length-1?",":"");
        }
    }

    public static void sort(int[] arr) {
        //i小于数组的长度减一因为冒泡排序最后剩下的那个数不需要冒泡了
        for (int i = 0; i < arr.length-1; i++) {
            //j减去i是因为已经有i个数冒过泡了
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
