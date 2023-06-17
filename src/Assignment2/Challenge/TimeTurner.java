package Assignment2.Challenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TimeTurner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] schedule=new int[n][2];
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            schedule[i][0]=sc.nextInt();
            schedule[i][1]=sc.nextInt();
        }
        Arrays.sort(schedule,Comparator.comparingInt(a->a[1]));
        int currentEndTime=0;
        int count=0;
        for(int i=0;i<=k;i++){
            //currentEndTime=Integer.MIN_VALUE;
            // for(int j=0;j<n;j++){
            //     if(visited[j]==0 && schedule[j][0]>currentEndTime){
            //         count++;
            //         currentEndTime=schedule[j][1];
            //         visited[j]=1;
            //     }
            // }
            int[][] memo = new int[schedule.length][schedule[schedule.length-1][1]+1];
            count+=getAns(schedule, 0, visited, currentEndTime,memo);
        }
        System.out.println(count);
    }

    public static int getAns(int[][] schedule, int i, int[] visited, int currentEndTime, int[][] memo){
        if(i==schedule.length)
        return 0;
        if(visited[i]!=0)
        return getAns(schedule, i+1, visited, currentEndTime,memo);
        int max=0;
        max=getAns(schedule, i+1, visited, currentEndTime,memo);
        if(schedule[i][0]>currentEndTime){
            int currentMax=1+getAns(schedule, i+1, visited, schedule[i][1],memo);
            if(currentMax>max){
                max=currentMax;
            }
        }
        return memo[i][currentEndTime] =max;
    }
    
}
