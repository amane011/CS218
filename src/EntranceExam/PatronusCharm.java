package EntranceExam;
import java.util.Scanner;

public class PatronusCharm{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i=n;
        int j=0;
        int[] arr=new int[n];
        while(i-->0){
            arr[j++]=s.nextInt();
        }
        int[] dp = new int[n];
        for ( i = 0; i < n; i++) {
            dp[i] = arr[i];
        }
        int maxSum = dp[0];
        for ( i = 1; i < n; i++) {
            for ( j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }
}