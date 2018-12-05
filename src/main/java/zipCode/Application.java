package zipCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by vasavivempati on 12/2/18.
 */
public class Application {
    public static void main(String[] args){
        BufferedReader lineOfText = new BufferedReader(new InputStreamReader(System.in));
        String textLine = "";
        ArrayList<Range> input = new ArrayList<Range> () ;
        Range singularInput = new Range();
        ZipCodeParser addZips = new ZipCodeParser();
        System.out.println("Please enter ranges in the format [xxxxx,xxxxx],[xxxxx,xxxxx]... etc and make sure " +
                "that the range end immediately follows the range beginning ");
        try {
            textLine = lineOfText.readLine();
            String[] tokens = textLine.split(" ");
            for (int i =0; i < tokens.length ; i++)
            {
                singularInput.setFloor( Integer.parseInt(tokens[i]));
                singularInput.setCeiling( Integer.parseInt(tokens[i+1]));
                input.add(singularInput);
                i = i+2;
            }

            ArrayList<Range> listOfZips = addZips.add_element(input); // adding all the zips to the list
            for(Range range:listOfZips)
            {
                listOfZips = addZips.eliminateDuplicates(listOfZips,range);
            }

        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }


    }
}

