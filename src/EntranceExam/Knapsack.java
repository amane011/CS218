package EntranceExam;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int weight =s.nextInt();
        int n=s.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        for(int i=0;i<n;i++){
            w[i]=s.nextInt();
            v[i]=s.nextInt();
        }
        int[][] dp=new int[n+1][weight+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int ans=getKnapsack(weight,n,w,v,dp);
        System.out.println(ans);
    }

    private static int getKnapsack(int weight, int n, int[] w, int[] v, int[][] dp) {
        if(n==0 || weight==0)
        return 0;
        if(dp[n][weight]!=-1)
        return dp[n][weight];

        if(w[n-1]>weight){
            return dp[n][weight] =getKnapsack(weight, n-1, w, v, dp);
        }
        return dp[n][weight]=Math.max(v[n-1]+getKnapsack(weight-w[n-1], n-1, w, v, dp), getKnapsack(weight, n-1, w, v, dp));
    }
}
