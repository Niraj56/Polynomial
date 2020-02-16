
public class Main {   // Save as "Hello.java"
   public static void main(String[] args) {  // Program entry point
     
      Polynomial p1  = new Polynomial("p1.txt");
      Polynomial p2  = new Polynomial("p2.txt");
      
      Polynomial p3 = p1.Add(p2);
      Polynomial p4 = p1.Substract(p2);
      Polynomial p5 = p1.Multiply(p2);
      
      System.out.println("Result of addition is: " + p3.toString());   // Print text message
      
      System.out.println("Result of substraction is: " + p4.toString());   // Print text message
      System.out.println("Result of multiplication is: " + p5.toString());   // Print text message
     
   }
}