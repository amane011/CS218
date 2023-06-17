package Assignment4;

import java.util.Arrays;
import java.util.Scanner;

public class LongestUnidomalSeq {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ans=getAns(arr,n);
        System.out.println(ans);
    }

    private static int getAns(int[] arr, int n) {   
            int[] inc=new int[n];
            int[] dec=new int[n];
            Arrays.fill(inc, 1);
            Arrays.fill(dec, 1);
            for (int i=1;i<n;i++) {
                for (int j=0;j<i;j++) {
                    if (arr[i]>arr[j] && inc[i]< inc[j]+1) {
                        inc[i]=inc[j]+1;
                    }
                }
            }
            for (int i =n-2;i>= 0;i--) {
                for (int j=n-1;j>i;j--) {
                    if (arr[i]>arr[j] && dec[i]<dec[j]+1) {
                        dec[i]=dec[j]+1;
                    }
                }
            }
            int ans=0;
            for (int i=0; i<inc.length;i++) {
                ans = Math.max(ans, (inc[i]+dec[i])-1);
            }
            return ans;
    }
    
}
