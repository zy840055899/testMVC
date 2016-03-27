package query;

/**
 * Created by zhengying on 16/3/27.
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        //从小到大排序
        int[] a = new int[100000000];
//        int[] a = {0, 2, 5, 9, 10, 11, 23, 43, 99, 100};
        for (int i = 0; i<100000000; i++){
            a[i] = i;
        }
        int low = 0, high = a.length, mid, loc = -1;
        int goal = 1;
        long start = System.currentTimeMillis();
        while (low <= high) {
            mid = (low + high) / 2;
            if (goal < a[mid]) {
                high = mid - 1;
            } else if (goal > a[mid]) {
                low = mid + 1;
            } else {
                loc = mid;
                break;
            }
        }
        long end = System.currentTimeMillis();
        //不到1ms
        System.out.println("元素的位置下标是:" + loc + ",耗时:" + (end - start) + "ms");
    }
}
