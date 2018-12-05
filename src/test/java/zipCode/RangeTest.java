package zipCode; /**
 * Created by vasavivempati on 12/2/18.
 */
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class RangeTest  {
 @Test
  void testOnlyAddZipCodes(){
    ArrayList<Range> sampleInput = new ArrayList<Range> ();
    Range sample = new Range();
     Range sample1 = new Range();
     Range sample2 = new Range();

     sample.setFloor(94133);
    sample.setCeiling(94133);
    sampleInput.add(0,sample);
    sample1.setFloor(94200);
    sample1.setCeiling(94299);
    sampleInput.add(1,sample1);
    sample2.setFloor(94226);
    sample2.setCeiling(94399);
    sampleInput.add(2,sample2);
    for(int i=0; i<3;i++){
        System.out.print(sampleInput.get(i).getCeiling());
        System.out.print("   ");
        System.out.print(sampleInput.get(i).getFloor());
        System.out.println("h");


    }
    ZipCodeParser addZips = new ZipCodeParser();
    addZips.add_element(sampleInput);
  }
  @Test
    void testDeleteDuplicateElements()
  {
      ArrayList<Range> sortedRanges = new ArrayList<Range>();
      ArrayList<Range> sampleInput = new ArrayList<Range> ();
      Range sample = new Range();
      Range sample1 = new Range();
      Range sample2 = new Range();

      sample.setFloor(94133);
      sample.setCeiling(94133);
      sampleInput.add(0,sample);
      sample1.setFloor(94200);
      sample1.setCeiling(94299);
      sampleInput.add(1,sample1);
      sample2.setFloor(94226);
      sample2.setCeiling(94399);
      sampleInput.add(2,sample2);
      for(int i=0; i<3;i++){
          System.out.print(sampleInput.get(i).getCeiling());
          System.out.print("   ");
          System.out.print(sampleInput.get(i).getFloor());
          System.out.println("h");


      }
      ZipCodeParser addZips = new ZipCodeParser();
      sortedRanges = addZips.add_element(sampleInput);
      Boolean duplicate = false;
      for (Range r:sortedRanges) {
          addZips.eliminateDuplicates(sortedRanges,r);
      }
  }

 }

