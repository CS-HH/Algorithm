package sort;

/**
 * 快速排序
 *
 * @author exphuhong
 * @since 20:16 2018/4/19
 */
public class QuickSort {


    public static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //选取最左边的数为中间数
        int value = arr[l];
        int i = l, j = r;
        for (;;) {
            while (arr[j] >= value&&i<j) {j--;}
            if (i < j) {
                swap(arr, i, j);
                i++;
            } else {
                break;
            }
            while (arr[i]<=value&&i<j){i++;}
            if (i < j) {
                swap(arr, i, j);
                j--;
            } else {
                break;
            }
        }
        sort(arr,l,i-1);
        sort(arr,i+1,r);

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 11, 15, 1, 3, 8,2,3,10};
        sort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(i<arr.length-1?",":"");
        }
    }
}
