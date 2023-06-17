package Assignment3.Training.Challenge;
import java.util.Scanner;
 
public class OnlineCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int n = sc.nextInt();
        int[][] classes = new int[n][3];
        for (int i = 0; i < n; i++) {
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
            classes[i][2] = sc.nextInt();
        }
        int[][] memo = new int[budget + 1][n + 1];
        System.out.println(getMaxValue(budget, n, classes, memo, new boolean[n]));
    }
 
    private static int getMaxValue(int budget, int n, int[][] classes, int[][] memo, boolean[] purchased) {
        if (n == 0 || budget == 0) {
            return 0;
        }
        if (memo[budget][n] > 0) {
            return memo[budget][n];
        }
        int price = classes[n - 1][0];
        int rating = classes[n - 1][1];
        int mainCourseId = classes[n - 1][2];
        int value = rating * price;
        int maxValue = 0;
        maxValue = getMaxValue(budget, n - 1, classes, memo, purchased);
        if (price <= budget) {
            if (mainCourseId == 0) {
                purchased[n - 1] = true;
                for(int i=0;i<classes.length;i++){
                    maxValue = Math.max(maxValue, getMaxValue(budget - price, n - 1, classes, memo, purchased) + value);
                    if(classes[i][2]==n && !purchased[i]){
                        int discPrice = classes[i][0];
                        int discRating = classes[i][1];
                        if(price + discPrice <= budget){
                            purchased[i]=true;
                            Math.max(maxValue,
                             getMaxValue(budget - price - discPrice, n, classes, memo, purchased)
                              + value +(discPrice*discRating));
                            purchased[i]=false;
                        }
                    }
                }
            }
                purchased[n - 1] = false;
            } 
        memo[budget][n] = maxValue;
        return maxValue;
    }
}