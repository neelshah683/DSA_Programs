package Stack_Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.*;

class Pair{
    int health;
    char direc;
    Pair(int x, char c){
        this.health = x;
        this.direc = c;
    }
}
public class robotCollisions {
    public static void main(String[] args) {
        int[] positions = {3, 5, 2, 6};
        int[] healths = {10, 10, 15, 12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = positions.length;
        int[] orgArr= positions.clone();

        for(int indx = 0; indx < n; indx++)
            map.put(positions[indx], new Pair(healths[indx], directions.charAt(indx)));
        
        Arrays.sort(positions);

        Stack<Integer> st = new Stack<>();

        for(int indx = 0; indx < n; indx++){

            int flag = 1;

            while(!st.isEmpty() && map.get(positions[indx]).direc == 'L' && map.get(st.peek()).direc == 'R' ){

                int health1 = map.get(st.peek()).health;
                int health2 = map.get(positions[indx]).health;

                if(health1 > health2){
                    map.put(st.peek(), new Pair(health1-1, map.get(st.peek()).direc));
                    flag = 0;
                    break;
                }
                else if(health1 < health2){
                    st.pop();
                    map.put(positions[indx], new Pair(health2-1, map.get(positions[indx]).direc));
                }
                else{
                    st.pop();
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                st.push(positions[indx]);
        }

        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        while(!st.isEmpty()){
            int key = st.pop();
            map2.put(key, map.get(key).health);
        }

        for(int indx = 0; indx < n; indx++){
            if(map2.containsKey(orgArr[indx]))
                res.add(map2.get(orgArr[indx]));
        }
        return res;
    }
}
