package Assignment3.Training;
import java.util.Scanner;

public class CandyString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] cost=new int[k];
        for (int i=0;i<k;i++) {
            cost[i]=sc.nextInt();
        }
        sc.nextLine(); 
        String candy=sc.nextLine();
        System.out.println(getAns(candy, cost));
    }

    // private static int getCost(String s, int l, int r,int[] cost){
    //     if(l>=r){
    //         return 0;
    //     }
    //     if(s.charAt(l)==s.charAt(r)){
    //         return getCost(s, l+1, r+1, cost);
    //     }
    //     int left=getCost(s, l+1, r, cost)+cost[s.charAt(l)-'a'];
    //     int right=getCost(s, l, r-1, cost)+cost[s.charAt(r)-'a'];
    //     return Math.min(left, right);
    // }
    private static int getAns(String s, int[] cost) {
        int n=s.length();
        int[][]dp=new int[n][n];
        for (int i=2;i<=n;i++) {
            for (int j=0;j< n-i+1;j++) {
                int l=j+i-1;
                if (s.charAt(j)==s.charAt(l)) {
                    dp[j][l]=dp[j+1][l-1];
                }else{
                    dp[j][l]=Math.min(dp[j+1][l]+ cost[s.charAt(j)-'a'],dp[j][l-1] +cost[s.charAt(l)-'a']);
                }
            }
        }
        return dp[0][n-1];
    }
}
