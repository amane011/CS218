package Assignment2.Challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ladders {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Line> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Line(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        ArrayList<Intersection> inter=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double[] a=list.get(i).getIntersection(list.get(j));
                if(a!=null){
                    inter.add(new Intersection(i, j, a));
                }
            }
        }
        inter.sort(Comparator.comparing((Intersection i) -> i.point[0]).thenComparing(i -> i.point[1]));
        Intersection intersection=inter.get(k-1);
        System.out.println((intersection.i+1)+" "+(intersection.j+1));
        
    }
}
class Line {
    double A, B, C;
    int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        A = y2-y1;
        B = x1-x2;
        C = x2*y1-x1*y2;
    }
    public double[] getIntersection(Line l1) {
        double det=A*l1.B-B*l1.A;
        if (det==0) {
            return null;
        }
        double x = (l1.C * B - C * l1.B) / det;
        double y = (A * l1.C - l1.A * C) / det;
        return new double[]{x, y};
    }
}

 class Intersection {
    int i;
    int j;
    double[] point;

    public Intersection(int i, int j, double[] point) {
        this.i = i;
        this.j = j;
        this.point = point;
    }
}
