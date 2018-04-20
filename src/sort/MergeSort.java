package sort;

/**
 * 归并排序
 *
 * @author exphuhong
 * @since 20:51 2018/4/20
 */
public class MergeSort {


    /**
     * 合并排序数组
     */
    public static void merge(int[] arr, int l, int m, int r) {
        int[] newArray1 = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;


        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                newArray1[k++] = arr[i++];
            } else {
                newArray1[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=m){
            newArray1[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=r){
            newArray1[k++] = arr[j++];
        }

        // 把新数组中的数覆盖arr数组
        for(int x=0;x<newArray1.length;x++){
            arr[x+l] = newArray1[x];
        }
    }

    /**
     * 拆分数组
     */
    public static void split(int[] arr, int l,int r) {
        int m = (l + r) / 2;
        if (l < r) {
            split(arr, l, m);
            split(arr, m + 1, r);
            merge(arr,l,m,r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 15, 1, 3, 8,2,3,10,9,20};
        split(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(i<arr.length-1?",":"");
        }
    }



}
