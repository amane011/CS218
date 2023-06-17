package Assignment4;

import java.io.*;
import java.util.*;
 
public class MaxTreeSum {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] weights = new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(n);
        for (int i=0;i<n;i++) {
            weights[i]=Integer.parseInt(reader.readLine());
            adj.add(new ArrayList<Integer>());
        }
        for (int i=1;i<n;i++) {
            int parentNode=Integer.parseInt(reader.readLine());
            adj.get(parentNode).add(i);
        }
        result=0;
        getAns(0, -1, adj, weights);
        System.out.println(result);
    }
    public static void getAns(int currentNode, int previousNode, ArrayList<ArrayList<Integer> > adj, int A[]) {
        ArrayList<Integer> v=adj.get(currentNode);
        int max1=0;
        int max2=0;
        int i=0;
        while(i<v.size()) {
            if (v.get(i)==previousNode) {
                i++;
                continue;
            }
            getAns(v.get(i), currentNode, adj, A);
            if (A[v.get(i)]>max1) {
                max2=max1;
                max1=A[v.get(i)];
            }
            else {
                max2=Math.max(max2, A[v.get(i)]);
            }
            i++;
        }
        result = Math.max(result, A[currentNode]+max1+max2);
        A[currentNode] += max1;
    }
 
    
}
