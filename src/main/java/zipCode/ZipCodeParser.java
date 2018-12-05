package zipCode;

import zipCode.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vasavivempati on 12/2/18.
 */

public class ZipCodeParser extends Range implements Comparable<ArrayList<Range>>{

    private ArrayList<Range> finalOutput = new ArrayList<Range> () ;
    public ArrayList<Range> getFinalOutput()
    {
        return finalOutput;
    }
    @Override
    public int compareTo(ArrayList<Range> first){
        return Integer.compare(first.get(0).getFloor(),first.get(1).getFloor());
    }
    // comparing each range to each other
    // should compare all range by end of loop
    public ArrayList<Range> add_element(ArrayList<Range> input){

        Collections.sort(input, new Comparator<Range>() {
            @Override
            public int compare(Range first, Range second) {
                return Integer.compare(first.getFloor(),second.getFloor());
            }
        });

        ArrayList<Range> output = new ArrayList<Range> () ;
        output.add(0,input.get(0));
        for (int i=1;i<input.size();i++ ){
            if(canBeAdded(output,input.get(i)) == true){
                output.add(input.get(i));
            }
        }
        return output;
    }

    //method to check if we can add the new element to the existing list of ranges
    // the existing list should only be one range
    // should only be comparing two ranges at a time
    public Boolean canBeAdded(ArrayList<Range> existingList, Range element){


        boolean mergeable = false;
        for(Range existingElement:existingList) {

            // if element's getCeiling() is firmly outside (less than) the range by having its getCeiling() be less than the getFloor() of the element
            // we are comparing it to
            // extending the getFloor()
            if (element.getCeiling() > existingElement.getFloor()) {
                mergeable = true;
            }
            // if the element's getFloor() is firmly outside (greater than the current getCeiling()) by having its getFloor() be
            // greater than the getCeiling() of the element that we're comparing it to then we can add it
            // extending the getCeiling()
            else if (element.getFloor() < existingElement.getCeiling()) {
                mergeable = true;
            }
            // if element is within the range of existing getFloor() can be added
            else if (existingElement.getFloor() <= element.getFloor() && element.getFloor() <= existingElement.getCeiling()) {
                mergeable = true;
            }
            // if element is within the range of existing getCeiling() can be added

            else if (existingElement.getFloor() <= element.getCeiling() && element.getFloor() <= existingElement.getCeiling()) {
                mergeable = true;
            }
            // the element is firmly within the range of the existing range we're comparing it
            else if (element.getFloor() <= existingElement.getFloor() && existingElement.getFloor() <= element.getCeiling()) {
                mergeable = true;
            }
        }
        return mergeable;
    }

    // remove the ranges that are contained within exisiting ranges
    public ArrayList<Range> eliminateDuplicates(ArrayList<Range> existingList, Range currentRange)
    {
        for (Range range: existingList)
        {
            if(currentRange.getFloor() < range.getFloor()){
                range.setFloor( currentRange.getFloor());
            }
            if(currentRange.getCeiling() < range.getCeiling()){
                range.setCeiling(currentRange.getCeiling());
            }
        }
        finalOutput = existingList;
        return finalOutput;
    }
    // add check to see input is a valid range

}
