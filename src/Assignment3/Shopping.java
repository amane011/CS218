package Assignment3;
import java.util.*;

class Item {
    int originalPrice, currentPrice, group;
    Item(int p, int t, int g) {
        originalPrice = p;
        currentPrice = t;
        group = g;
    }
}

public class Shopping {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(100, 70, 1),
            new Item(50, 30, 1),
            new Item(200, 150, 2),
            new Item(80, 60, 3),
            new Item(100, 70, 3),
            new Item(80, 60, 2)
        );
        int budget = 300;
        int n = items.size();

        // Group the items
        Map<Integer, List<Item>> groups = new HashMap<>();
        for (Item item : items) {
            groups.putIfAbsent(item.group, new ArrayList<>());
            groups.get(item.group).add(item);
        }

        // Initialize dp table and item list table
        int[][] dp = new int[n + 1][budget + 1];
        Item[][] buy = new Item[n + 1][budget + 1];

        // Iterate over groups
        int i = 1;
        for (List<Item> group : groups.values()) {
            // Copy previous row
            for (int j = 0; j <= budget; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // Iterate over items in group
            for (Item item : group) {
                int itemCost = item.currentPrice;
                int itemBenefit = item.originalPrice - item.currentPrice;

                // Iterate over all budgets from W to item's cost
                for (int j = budget; j >= itemCost; j--) {
                    // Update dp[i][j] and buy[i][j] if the item's cost is <= budget
                    if (itemBenefit + dp[i - 1][j - itemCost] > dp[i][j]) {
                        dp[i][j] = itemBenefit + dp[i - 1][j - itemCost];
                        buy[i][j] = item;
                    }
                }
            }

            i++;
        }

        // Print maximum benefit
        System.out.println("Maximum benefit: " + dp[n][budget]);

        // Recreate the solution
        List<Item> boughtItems = new ArrayList<>();
        int j = budget;
        for (i = n; i > 0; i--) {
            if (buy[i][j] != null) {
                boughtItems.add(buy[i][j]);
                j -= buy[i][j].currentPrice;
            }
        }

        // Print bought items
        System.out.println("Bought items:");
        for (Item item : boughtItems) {
            System.out.println("Group: " + item.group + ", Original price: " + item.originalPrice + ", Current price: " + item.currentPrice);
        }
    }
}
