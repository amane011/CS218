
package Assignment5.Challenge;
import java.util.*;

public class Capital {
    ArrayList<ArrayList<Integer>> adj, adjT;
    int[] vis;
    int[] visited;
    Stack<Integer> stack;
    int n, m;
    ArrayList<Integer> scc;

    private void dfs(int node) {
        vis[node]=1;
        for (Integer i : adj.get(node)) {
            if (vis[i]==0) {
                dfs(i);
            }
        }
        stack.push(node);
    }

    private void reverseDFS(int node) {
        vis[node]=1;
        scc.add(node);
        for (Integer i:adjT.get(node)) {
            if (vis[i]==0) {
                reverseDFS(i);
            }
        }
    }

    public void findCapital() {
        int count=0;
        vis = new int[n+1];
        stack = new Stack<Integer>();
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        count++;
        vis = new int[n+1];
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (vis[node] == 0) {
                scc = new ArrayList<>();
                reverseDFS(node);
            }
        }

        vis = new int[n+1];
        for (Integer node : scc) {
            vis[node] = 1;
        }

        for (Integer node : scc) {
            for (Integer it : adj.get(node)) {
                if (vis[it] == 0) {
                    System.out.println("0");
                    return;
                }
            }
        }
        count=count-1;
        Collections.sort(scc);
        System.out.println(scc.size());
        for (int i=0;i<scc.size();i++) {
            System.out.print(scc.get(i) + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Capital obj = new Capital();
        obj.n = n;
        obj.adj = new ArrayList<>();
        obj.adjT = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            obj.adj.add(new ArrayList<Integer>());
            obj.adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            obj.adj.get(u).add(v);
            obj.adjT.get(v).add(u);
        }
        obj.findCapital();
    }
}
