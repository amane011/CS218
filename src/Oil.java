import java.util.PriorityQueue;

public class Oil {
    public static void main(String[] args) {
        // Test case
    int fuel = 8;
    int[][] stations = {
        {5, 2},
        {7, 8},
        {12, 1},
        {16, 3},
        {20,4},
        {26,0}
    };

    int result = minRefuelStops(fuel, fuel, stations, 0);
    System.out.println("Minimum number of refueling stops: " + result);

    }
    public static int minRefuelStops(int reachable, int fuel, int[][] stations, int i) {
        if(i==stations.length-1)
        return 0;
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<stations.length-1;j++){
            if(stations[j][0]<=reachable){
                ans=Math.min(ans, stations[j][1]+minRefuelStops(stations[j][0]+fuel, fuel, stations, j+1));
            }else{
                break;
            }
        }
        return ans;
    }
}
