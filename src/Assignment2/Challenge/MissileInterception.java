package Assignment2.Challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MissileInterception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long x1=sc.nextLong();
        Long y1=sc.nextLong();
        Long x2=sc.nextLong();
        Long y2=sc.nextLong();
        int n=sc.nextInt();
        Missile[] missiles = new Missile[n];
        for (int i = 0; i < n; ++i) {
            long x = sc.nextLong(), y = sc.nextLong();
            long d1=(x-x1)*(x-x1)+(y -y1)*(y-y1);
            long d2=(x-x2)*(x-x2)+(y - y2)*(y-y2);
            missiles[i]=new Missile(x, y,d1,d2);
        }
        Arrays.sort(missiles, Comparator.comparingLong(a -> a.d1));
        long[] maxD2=new long[n];
        maxD2[n-1]=missiles[n-1].d2;
        for (int i=n-2;i>=0;--i) {
            maxD2[i]=Math.max(maxD2[i+1],missiles[i].d2);
        }
        long res=Math.min(missiles[n-1].d1, maxD2[0]);
        long d1Max=missiles[0].d1;
        for (int i=1;i<n;++i) {
            res=Math.min(res,d1Max+ maxD2[i]);
            d1Max = Math.max(d1Max, missiles[i].d1);
        }
        System.out.println(res);
    }
}
class Missile {
    long x;
    long y;
    long d1;
    long d2;
    public Missile(long x, long y, long d1, long d2) {
        this.x=x;
        this.y=y;
        this.d1=d1;
        this.d2 =d2;
    }
}