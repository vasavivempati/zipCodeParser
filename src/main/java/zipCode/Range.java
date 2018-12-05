package zipCode;

/**
 * Created by vasavivempati on 12/2/18.
 */
public class Range {
    private int floor;
    private int ceiling;
    public int getFloor(){
        return floor;
    }
    public int getCeiling(){
        return ceiling;
    }
    public int setFloor(int newFloor){
        floor = newFloor;
        return floor;
    }
    public int setCeiling(int newCeiling){
        ceiling = newCeiling;
        return ceiling;
    }

}
