package lpl.util;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsvFiles {

 public static void main(String[] args) throws Exception {
    
 // This will load csv file 
 CSVReader reader = new CSVReader(new FileReader(TestUtil.TESTDATA_CSV_PATH));

 // this will load content into list
  List<String[]> list=reader.readAll();
  System.out.println("Total rows which we have is "+list.size());
            
 // create Iterator reference
  Iterator<String[]>i1= list.iterator();
    
 // Iterate all values 
 while(i1.hasNext()){
     
 String[] stringArray=i1.next();
   
 System.out.print(" Values are ");

 for(int i=0;i<stringArray.length;i++)
{

   System.out.print(" "+stringArray[i]+"\t");

}
   System.out.println("   ");
     
    
}

}

}