package EntranceExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BlackFamilyTree {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        int t=Integer.parseInt(reader.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int p =Integer.parseInt(reader.readLine());
            graph[p].add(i);
        }
        boolean[] traitors = new boolean[n];
        for (int i = 0; i < t; i++) {
            traitors[Integer.parseInt(reader.readLine())] = true;
        }
        boolean[] visited=new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!traitors[i] && !visited[i]) {
                max = Math.max(max, dfs(graph, traitors, i,visited));
            }
        }
        System.out.println(max);
    }

    private static int dfs(ArrayList<Integer>[]tree, boolean[] traitors, int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!traitors[node]) {
                count++;
                visited[node]=true;
                for (int child: tree[node]) {
                    stack.push(child);
                }
            }
        }
        return count;
    }
}
