package heap;


//堆
public class Heap {
    int capacity;
    int size;
    int[] datas;
    public Heap(int capacity){
        this.capacity = capacity;
        datas = new int[capacity+1];
        size = 0;
    }
    public void insert(int data){
        if (size + 1> capacity){
            System.out.println("超出了容量 加入失败");
            return;
        }
        datas[size + 1] = data;
        size++;
        ShiftUp(size);
    }

    public int deletMax(){
        int ret = datas[1];
        swap(1,size);
        size --;
        ShiftDown(1);
        return ret;
    }

    private void ShiftDown(int i) {
        while(i*2 <= size){
            int j = i*2;
            if(j+1 <= size && datas[j]<datas[j+1]){
                j ++;
            }
            if(datas[j] <=datas[i]) break;
            swap(j,i);
            i = j;
        }
    }

    private void ShiftUp(int k) {
        while (datas[k/2] < datas[k] && k!=1){
            swap(k/2,k);
            k /= 2;
        }
    }

    private void swap(int i, int size) {
        int temp = datas[i];
        datas[i] = datas[size];
        datas[size] = temp;
    }

    public static void main(String[] args) {
        Heap mheap = new Heap(10);
        for (int i = 0 ; i< 10;i++){
            mheap.insert(i);
        }
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(mheap.datas[i]);
//        }
        for (int i = 0; i < 10; i++) {
            System.out.println(mheap.deletMax());
        }
    }
}
