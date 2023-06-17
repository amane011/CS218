package Assignment4.Challenge;
import java.util.*;

public class DogHappiness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] funness = new Pair[n+1];
        funness[0] = new Pair(0, 0);
        for (int i = 1; i <= n; i++) {
            funness[i] = new Pair(scanner.nextLong(), i);
        }

        Arrays.sort(funness, (a, b) -> b.value.equals(a.value) ? b.index - a.index : b.value.compareTo(a.value));
        
        long totalHappiness = 0;
        int maxIndexSoFar = funness[0].index;

        for (Pair pair : funness) {
            if (pair.index > maxIndexSoFar) {
                totalHappiness += pair.value;
                maxIndexSoFar = Math.max(maxIndexSoFar, pair.index);
            }
        }

        System.out.println(totalHappiness);
    }

    static class Pair {
        Long value;
        Integer index;

        Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
