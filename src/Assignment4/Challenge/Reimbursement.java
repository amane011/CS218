package Assignment4.Challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Reimbursement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;
        int s = scanner.nextInt();

        int[] hotelPrice = new int[n];
        for (int i = 0; i < n; i++)
            hotelPrice[i] = scanner.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        PriorityQueue<City> queue = new PriorityQueue<>();
        queue.add(new City(u, hotelPrice[u], s));

        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(u, hotelPrice[u]);

        while (!queue.isEmpty()) {
            City city = queue.poll();
            if (city.gas < 0 || city.maxCost > visited.get(city.id)) continue;
            if (city.id == v) {
                System.out.println(city.maxCost);
                return;
            }

            for (Edge edge : graph.get(city.id)) {
                int newGas = city.gas - edge.gas;
                int newMaxCost = Math.max(city.maxCost, hotelPrice[edge.to]);
                if (!visited.containsKey(edge.to) || newMaxCost < visited.get(edge.to)) {
                    visited.put(edge.to, newMaxCost);
                    queue.add(new City(edge.to, newMaxCost, newGas));
                }
            }
        }

        System.out.println("-1");
    }
}
 class Edge {
    int to, gas;

    Edge(int to, int gas) {
        this.to = to;
        this.gas = gas;
    }
}
class City implements Comparable<City> {
    int id, maxCost, gas;

    City(int id, int maxCost, int gas) {
        this.id = id;
        this.maxCost = maxCost;
        this.gas = gas;
    }

    @Override
    public int compareTo(City other) {
        return Integer.compare(maxCost, other.maxCost);
    }
}

