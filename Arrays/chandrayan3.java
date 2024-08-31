package Arrays;

class generateDirection{
    int x, y, z;
    String direction = "";

    public generateDirection(int x, int y, int z, String direction){
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }
    public void turnForward(){
        if(direction == "E" || direction == "W")
            x = (direction == "E") ? ++x : --x;
        else if(direction == "N" || direction == "S")
            y = (direction == "N") ? ++y : --y;
        else
            z = (direction == "U") ? ++z : --z;
    }
    public void turnBackward(){
        if(direction == "E" || direction == "W")
            x = (direction == "E") ? --x : ++x;
        else if(direction == "N" || direction == "S")
            y = (direction == "N") ? --y : ++y;
        else
            z = (direction == "U") ? --z : ++z;
    }
    public void turnLeft(){
        if(direction == "N")
            direction = "W";
        else if(direction == "S" )
            direction = "E";
        else if(direction == "E" || direction == "U")
            direction = "N";
        else 
            direction = "S";
    }
    public void turnRight(){
        if(direction == "N")
            direction = "E";
        else if(direction == "S")
            direction = "W";
        else if(direction == "E" || direction == "U")
            direction = "S";
        else
            direction = "N";
    }
    public void turnUp(){
        direction = "U";
    }
    public void turnDown(){
        direction = "D";
    }
    public String getFinalDirection(){
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
public class chandrayan3 {
    
    public static void main(String[] args) {
        String[] commands = {"f", "r", "u", "b", "l"};

        generateDirection gd = new generateDirection(0, 0, 0, "N");

        for(String cmd : commands){
            if(cmd.equals("f"))
                gd.turnForward();
            else if(cmd.equals("b"))
                gd.turnBackward();
            else if(cmd.equals("r"))
                gd.turnRight();
            else if(cmd.equals("l"))
                gd.turnLeft();
            else if(cmd.equals("u"))
                gd.turnUp();
            else
                gd.turnDown();
        }

        System.out.println("Final Position:"+gd.getFinalDirection());
        System.out.println("Final Direction:"+gd.direction);
    }
}
