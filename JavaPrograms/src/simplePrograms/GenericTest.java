package simplePrograms;

public class GenericTest {
		   // determines the largest of three Comparable objects
		   
		   public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		      T max = x;   // assume x is initially the largest
		      
		      if(y.compareTo(max) > 0) {
		         max = y;   // y is the largest so far
		      }
		      
		      if(z.compareTo(max) > 0) {
		         max = z;   // z is the largest now                 
		      }
		      return max;   // returns the largest object   
		   }
		   int i;
		   boolean b ;
		   public static void main(String args[]) {
		      System.out.printf("Max of %d, %d and %d is %d\n\n", 
		         3, 4, 5, maximum( 3, 4, 5 ));

		      System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
		         6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

		      System.out.printf("Max of %s, %s and %s is %s\n","pear",
		         "apple", "orange", maximum("pear", "apple", "orange"));
		      
		      
		      System.out.println(new GenericTest().i);
		      System.out.println(new GenericTest().b);
		      for(int i = 0; new GenericTest().b; i++) 
		      { 
		          System.out.println("Hello"); 
		          break; 
		      } 
		      
		      Double object = new Double("2.4");
		        int a = object.intValue();
		        System.out.println(a);
		        byte b = object.byteValue();
		        System.out.println(b);
		        float d = object.floatValue();
		        System.out.println( d );
		        double c = object.doubleValue();
		        System.out.println(c );
		        System.out.println(a + b + c + d );
		   }
		}