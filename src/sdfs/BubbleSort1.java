
package sdfs;

 
import java.util.Random;
import java.util.Date;
 

public class BubbleSort1 {
 
  static Comparable[] c;
 
    public static void sort( Comparable[] theArray, int n ) {
    boolean sorted = false;  
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < n - 1; i++) {
        if (theArray[i].compareTo(theArray[i + 1]) > 0 ){
          Comparable temp = theArray[i + 1];
          theArray[i + 1] = theArray[i];
          theArray[i] = temp;
          sorted = false;
        }
      }
      n--; 
    } 
  }
}