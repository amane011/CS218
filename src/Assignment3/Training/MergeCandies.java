package Assignment3.Training;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeCandies {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i=0;i<n;i++){
           queue.add(sc.nextLong());
        }
        long sum=Long.valueOf(0);
        while(queue.size()>1){
            long a1=queue.poll();
            long a2=queue.poll();
            queue.add(a1+a2);
            sum+=2*(a1+a2);
        }
        System.out.println(sum);
        

    }
}
