package Assignment2;
import java.util.Scanner;

public class ShareCandies {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[][] students=new long[n][2];
        long low=Long.MAX_VALUE;
        long high=0;
        for(int i=0;i<n;i++){
            students[i][0]=sc.nextLong();
            students[i][1]=sc.nextLong();
            high+=students[i][1];
        }
        low=0;
        long ans=0;
        //Arrays.sort(students, Comparator.comparingLong(a -> a[0]));
        while(low<=high){
            long mid =(low+high )/ 2;
            long[] arr = new long[n];
            for (int i=0; i<n; i++) {
                arr[i]=Long.valueOf(students[i][1]);
            }
            for(int i=0;i<n-1;i++){
                long dist=Math.abs(students[i][0]-students[i+1][0]);
                if((arr[i]-mid-dist)>0){
                    arr[i+1] =arr[i+1]+(arr[i]-mid-dist);
                    arr[i]=mid;
                } 
                if(arr[i]<mid){
                    arr[i+1]=arr[i+1]-(mid-arr[i])-dist;
                    arr[i]=mid;
                }
            }
            if(arr[n-1]<mid){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }
        System.out.println(ans);
    }
}
