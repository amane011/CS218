package Assignment1;

import java.util.HashSet;

public class BeingUnique {
    public static void main(String[] args) {
        int[] arr={1,2,3,1,2,3};
        HashSet<Integer> unique=new HashSet<>();
        HashSet<Integer> visited=new HashSet<>();
        unique.add(arr[0]);
        for(int i=1;i<arr.length && !unique.isEmpty();i++){
            int a=arr[i];
            if(unique.contains(a)){
                unique.remove(a);
                visited.add(a);
            }else{
                if(!visited.contains(a)){
                    unique.add(a);
                }
            }
        }
        if(unique.size()==0){
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }
}
