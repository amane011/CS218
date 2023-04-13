package Assignment1;
 
import java.util.Scanner;
import java.math.BigInteger;

public class SortTheTrain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextBigInteger();
        }
        BigInteger ans = mergeSort(arr, 0, n-1);
        System.out.println(ans);
    }

    private static BigInteger mergeSort(BigInteger[] arr, int l, int r) {
        BigInteger swaps = BigInteger.ZERO;
        int mid = 0;
        if (r > l) {
            mid = l + (r - l) / 2;
            swaps = swaps.add(mergeSort(arr, l, mid));
            swaps = swaps.add(mergeSort(arr, mid+1, r));
            swaps = swaps.add(merge(arr, l, mid, r));
        }
        return swaps;
    }

    private static BigInteger merge(BigInteger[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        BigInteger[] arr1 = new BigInteger[n1];
        BigInteger[] arr2 = new BigInteger[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[m + 1 + i];
        }
        BigInteger count = BigInteger.ZERO;
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
                count = count.add(BigInteger.valueOf(m + 1 - l - i));
            }
        }
        while (i < n1) {
            arr[k++] = arr1[i++];
        }
        while (j < n2) {
            arr[k++] = arr2[j++];
        }
        return count;
    }
}
