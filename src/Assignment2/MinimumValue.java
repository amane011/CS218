package Assignment2;

import java.util.Scanner;

public class MinimumValue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a= sc.nextDouble();
        double left=1.0;
        double right=2.0;
        double e=1e-6;
        double middle1, middle2, f1, f2;
        while(right-left>e){
            middle1=left+(right-left)/3;
            middle2=right-(right-left)/3;
            f1=functionCal(middle1, a);
            f2=functionCal(middle2, a);
            if (f1<f2) {
                right= middle2;
            } else {
                left= middle1;
            }
        }
        System.out.println(functionCal(left,a));
    }

    private static double functionCal(double x, double a){
        return ((x*x)/Math.log(x))+(a*x);
    }
}
