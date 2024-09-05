package Arrays;

public class robotSimulation {
    
    public static void main(String[] args) {
        int[] arr = {4,-1,4,-2,4};
        int[][] obs = {
            {2, 4}
        };
        System.out.println(robotSim(arr, obs));
    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int direction = 0, ans = 0;
        
        for(int getD : commands){
            if(getD == -1)//Turn Right
                direction = (direction + 1) % 4;
            else if(getD == -2)//Turn Left
                direction = (direction + 3) % 4;
            else{

                //North
                if(direction == 0){
                    int temp = y;
                    y += getD;
                    for(int[] coorD : obstacles){
                        if(coorD[0] == x){
                            if(y >= coorD[1] && coorD[1] - 1 >= temp)
                                y = coorD[1] - 1;
                        }
                    }
                }

                //East
                else if(direction == 1){
                    int temp = x;
                    x += getD;
                    for(int[] coorD : obstacles){
                        if(coorD[1] == y){
                            if(x >= coorD[0] && coorD[0] - 1 >= temp)
                                x = coorD[0] - 1;
                        }
                    }
                }

                //South
                else if(direction == 2){
                    int temp = y;
                    y -= getD;
                    for(int[] coorD : obstacles){
                        if(coorD[0] == x){
                            if(y <= coorD[1] && coorD[1] + 1 <= temp)
                                y = coorD[1] + 1;
                        }
                    }
                }

                //West
                else if(direction == 3){
                    int temp = x;
                    x -= getD;
                    for(int[] coorD : obstacles){
                        if(coorD[1] == y){
                            if(x <= coorD[0] && coorD[0] + 1 <= temp)
                                x = coorD[0] + 1;
                        }
                    }
                }

                ans = Math.max(ans, (x * x) +  (y * y));
            }
        }
        return ans;
    }
}
