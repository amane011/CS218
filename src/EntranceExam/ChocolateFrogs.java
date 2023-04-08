package EntranceExam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ChocolateFrogs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] cards=new int[n];
        int i=0;
        while(n-->0){
            cards[i++]=s.nextInt();
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int card: cards){
            if(map.containsKey(card)){
                map.replace(card, map.get(card)+1);
            }else{
                map.put(card,1);
            }
        }

         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
