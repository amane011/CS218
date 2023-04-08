package EntranceExam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BlackFamilyTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int p = sc.nextInt();
            graph[p].add(i);
        }
        boolean[] traitors = new boolean[n];
        for (int i = 0; i < t; i++) {
            traitors[sc.nextInt()] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!traitors[i]) {
                max = Math.max(max, dfs(graph, traitors, i));
            }
        }
        System.out.println(max);
    }

    private static int dfs(ArrayList<Integer>[]tree, boolean[] traitors, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!traitors[node]) {
                count++;
                for (int child: tree[node]) {
                    stack.push(child);
                }
            }
        }
        return count;
    }
}

