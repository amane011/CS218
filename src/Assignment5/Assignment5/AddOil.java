package Assignment5;
import java.util.*;

public class AddOil {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] parent=new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i]=i;
        }
        Edge[] edges = new Edge[m];
        for (int i=0;i<m;i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();
            edges[i]=new Edge(x, y, z);
        }
        Arrays.sort(edges);
        int maxEdgeWeight=-1;
        for (Edge edge:edges) {
            if (find(edge.u,parent)!=find(edge.v,parent)) {
                union(edge.u, edge.v,parent);
                maxEdgeWeight = Math.max(maxEdgeWeight, edge.w);
            }
        }
        System.out.println(maxEdgeWeight);
    }
    
    static int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }

    static void union(int x, int y, int[] parent) {
        parent[find(x,parent)] = find(y,parent);
    }
}
class Edge implements Comparable<Edge> {
        
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u=u;
        this.v=v;
        this.w= w;
    }

    public int compareTo(Edge edge) {
        return this.w - edge.w;
    }
}
