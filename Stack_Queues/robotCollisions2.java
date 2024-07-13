package Stack_Queues;

import java.util.Stack;
import java.util.*;

class Robot {
    int position;
    int health;
    char direction;
    int originalIndex;

    Robot(int position, int health, char direction, int originalIndex) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.originalIndex = originalIndex;
    }
}


public class robotCollisions2 {
    
    public static void main(String[] args) {
        int[] positions = {3, 5, 2, 6};
        int[] healths = {10, 10, 15, 12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;
        List<Integer> res = new ArrayList<>();

        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> Integer.compare(a.position, b.position));

        Stack<Robot> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Robot current = robots[i];
            boolean survived = true;

            while (!stack.isEmpty() && stack.peek().direction == 'R' && current.direction == 'L') {
                Robot top = stack.peek();
                if (top.health > current.health) {
                    top.health--;
                    survived = false;
                    break;
                } else if (top.health < current.health) {
                    stack.pop();
                    current.health--;
                } else {
                    stack.pop();
                    survived = false;
                    break;
                }
            }

            if (survived) {
                stack.push(current);
            }
        }

        Map<Integer, Integer> survivingRobots = new HashMap<>();
        while (!stack.isEmpty()) {
            Robot survivedRobot = stack.pop();
            survivingRobots.put(survivedRobot.originalIndex, survivedRobot.health);
        }

        for (int i = 0; i < n; i++) {
            if (survivingRobots.containsKey(i)) {
                res.add(survivingRobots.get(i));
            }
        }

        return res;
    }

}
