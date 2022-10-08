package wangzheng.datastruct;


public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a, i, i/2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i/2;
        }
    }

    private void swap(int[] a, int i, int i1) {
        int tmp=a[i];
        a[i]=a[i1];
        a[i1]=tmp;
    }

    private void removeMax(){
        if(count==0)
            return;
        a[1]=a[count];
        count--;//--count
        heapify(a,count,1);
    }

    private void heapify(int[] a, int n, int i) {
        while(true){
            int maxPos=i;
            if(2*i<=n && a[i]<a[2*i]) maxPos=2*i;
            if(2*i+1 <=n && a[maxPos]<a[2*i+1]) maxPos=2*i+1;

            if (maxPos==i) break;

            swap(a,i,maxPos);
            i=maxPos;
        }
//        if (a[2*i]>a[2*i+1]){
//            swap(a,i,2*i);
//        } else {
//            swap(a,i,2*1+1);
//        }
    }
}
