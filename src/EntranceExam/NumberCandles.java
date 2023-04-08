package EntranceExam;

import java.util.Scanner;
public class NumberCandles{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr=new int[9];
        for (int k = 0; k < 9; k++) {
            arr[k] = s.nextInt();
        }
        String[] dp=new String[n+1];
        for( int i=0;i<n+1;i++){
            dp[i]="";
        }
        for(int j=0;j<9;j++){
            for(int i=arr[j];i<=n;i++){
                String str1=Integer.toString(j+1)+dp[i-arr[j]];
                String str2=dp[i];
                dp[i]=myCompare(str1, str2);
            }
        }
        System.out.println(dp[n]);
    }


    private static String myCompare(String str1, String str2) {
        if (str1.length()>str2.length()) {
            return str1;
        } else if (str1.length()<str2.length()) {
            return str2;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i)>str2.charAt(i)) {
                    return str1;
                } else if (str1.charAt(i)<str2.charAt(i)) {
                    return str2;
                }
            }
        }
        return str1;
    }
    
}