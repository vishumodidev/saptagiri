package Day4_Test;

import java.util.Scanner;

public class TryCatchBasics {

  public static void main(String[] args)
  {
      Scanner sc= new Scanner(System.in);

      try{
          System.out.println("Enetr Numerator");
          int a=sc.nextInt();
          System.out.println("Enter Denominator");
          int b=sc.nextInt();

          int result=a/b;
          System.out.println("Result"+result);
      }catch (ArithmeticException e)
      {
          System.out.println("Error diving zero");

      }
      System.out.println("Programs runs continiuosly");
  }
}
