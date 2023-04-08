package EntranceExam;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TripNavigator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int time=sc.nextInt();
        char[][] grid=new char[n][n];
        for(int i=0;i<=n-1;i++){    
            grid[i]=sc.next().toCharArray();
        }
        int[][] visited=new int[n][n];
        int[][]dist=new int[n][n];
        for(int[] arr:visited){
            Arrays.fill(arr, -1);
        }
        for(int[] arr:dist){
            Arrays.fill(arr, -1);
        }
        //dp[n-1][n-1]=1;
        getPath(grid,0,0,time,visited,dist);
        System.out.println(dist[n-1][n-1]);
    }

    private static void getPath(char[][] grid, int i, int j, int time, int[][] visited, int[][] dist) {
        PriorityQueue<MyNode> queue=new PriorityQueue<>();
        queue.add(new MyNode(i,j,0));
        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        while(!queue.isEmpty()){
            MyNode node=queue.poll();
            i=node.i;
            j=node.j;
            int d=node.d;
            if(visited[i][j]!=-1)
            continue;
            visited[i][j]=1;
            dist[i][j]=d;
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                    int cost;
                    if(grid[x][y]=='-'){
                        cost=1;
                    }else{
                        cost=1+time;
                    }
                    int nd=d+cost;
                    queue.add(new MyNode(x, y, nd));
                }
            }
        }
    }
    
}
class MyNode implements Comparable<MyNode> {
        int i, j, d;
        
         MyNode(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
        
        public int compareTo(MyNode m) {
            return Integer.compare(d, m.d);
        }
}