package Assignment5;
import java.util.*;
import java.io.*;

public class Shelter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
         int n, m,b;
         boolean[] visited;
         int[] match;
        int[][] cost;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        b = Integer.parseInt(s[2]);
        
        int[][] students = new int[n][3];
        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            students[i][0]=Integer.parseInt(s[0]);
            students[i][1]=Integer.parseInt(s[1]);
            students[i][2]=Integer.parseInt(s[2]);
        }
        
        int[][] shelters=new int[m][2];
        for(int i=0; i<m; i++) {
            s=br.readLine().split(" ");
            shelters[i][0]=Integer.parseInt(s[0]);
            shelters[i][1]=Integer.parseInt(s[1]);
        }
        
        cost=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int dx =students[i][0]-shelters[j][0];
                int dy =students[i][1]-shelters[j][1];
                double distance=Math.sqrt(dx*dx + dy*dy);
                int time=(int)Math.ceil(distance/students[i][2]);
                cost[i][j] = (time > b) ? 1 : 0;
            }
        }
        
        match = new int[m];
        visited = new boolean[m];
        int ans = 0;
        Arrays.fill(match, -1);
        for(int i=0;i<n;i++) {
            Arrays.fill(visited, false);
            if(find(i, cost, visited, match, m)==false) {
                ans++; 
            }
        }
        
        System.out.println(ans);
    }
    
    static boolean find(int u, int[][] cost, boolean[] visited, int[] match, int m) {
        for(int v=0; v<m; v++) {
            if(cost[u][v] == 0 && visited[v]==false) {
                visited[v] = true;
                if(match[v] == -1 || find(match[v], cost, visited, match, m)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
