package Assignment3.Training.Challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class OfficeHours {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        PriorityQueue<Integer> prof=new PriorityQueue<>();
        for(int i=0;i<m;i++){
            prof.add(sc.nextInt());
        }
        PriorityQueue<int[]> student=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int i=0;i<n;i++){
            int[] a=new int[2];
            a[0]=sc.nextInt();
            a[1]=sc.nextInt();
            student.add(a);
        }
        int count=0;
        while(!prof.isEmpty()){
            int freeDay=prof.poll();
            while (!student.isEmpty() && student.peek()[1] < freeDay) {
                student.poll();
            }
            if (!student.isEmpty() && student.peek()[0] <= freeDay) {
                count++;
                student.poll();
            }
        }
        System.out.println(count);
    }
}
