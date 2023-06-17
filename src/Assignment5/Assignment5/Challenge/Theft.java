package Assignment5.Challenge;
import java.util.*;
import java.io.*;
 
public class Theft {
    static int V;
    static int j;
    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        int a=0;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i){
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (queue.size() != 0) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    a++;
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }
 
    int fordFulkerson(int graph[][], int s, int t)
    {
        int u=0;
        int v=0;
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
        int parent[] = new int[V];
        int max_flow = 0;
        boolean ans=bfs(rGraph, s, t, parent);
        while (ans) {
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
 
            for (v=t;v!=s;v=parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            max_flow = max_flow+ path_flow;
            ans=bfs(rGraph, s, t, parent);
        }
        return max_flow;
    }
 
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        V = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken()) - 1; 
        int B = Integer.parseInt(st.nextToken()) - 1; 
 
        int graph[][] = new int[V][V];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1; 
            int v = Integer.parseInt(st.nextToken()) - 1; 
            int c = Integer.parseInt(st.nextToken());
 
            graph[u][v] = c;
            graph[v][u] = c; 
        }
 
        Theft z = new Theft();
        System.out.println(z.fordFulkerson(graph, A, B));
    }
}

