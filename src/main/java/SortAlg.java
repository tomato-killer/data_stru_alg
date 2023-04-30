import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SortAlg {

    private static Random random = new Random();

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, i, j);
                }
            }
            if (!flag)
                break;
        }
    }


    //选择排序
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else
                    break;
            }
        }
    }


    //希尔排序
    public static void shellSort(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }


    //归并排序
    public static void mergeSort(int[] arr) {

        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] ori = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid)
                arr[k] = ori[j++ - l];
            else if (j > r)
                arr[k] = ori[i++ - l];
            else if (ori[i - l] < ori[j - l])
                arr[k] = ori[i++ - l];
            else
                arr[k] = ori[j++ - l];
        }
    }


    //快排
    private static LinkedList<Integer> quickSort(LinkedList<Integer> arr) {
        if (arr.size() > 2) {
            LinkedList right = new LinkedList<Integer>();
            LinkedList left = new LinkedList<Integer>();
            int flag = arr.get(random.nextInt(arr.size()));
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) >= flag)
                    right.add(arr.get(i));
                else
                    left.add(arr.get(i));
            }
            right = quickSort(right);
            left = quickSort(left);
            left.addAll(right);
            return left;
        }else if (arr.size() == 2){
            if (arr.get(0) > arr.get(1)){
                LinkedList<Integer> list = new LinkedList<>();
                list.add(arr.get(1));
                list.add(arr.get(0));
                return list;
            }else{
                return arr;
            }
        }else{
            return arr;
        }
    }



    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, -1, 5, 20, 10, 9};
//        mergeSort(arr);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);list.add(3);list.add(-1);list.add(5);list.add(20);list.add(10);list.add(9);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        LinkedList<Integer> arr = quickSort(list);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }



    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}


