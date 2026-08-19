package Day4_Test;

public class MultipleCatchExample {
    public static void main(String[] args)
    {
        try {
 int[] numbers={10,20,30};

 int a=Integer.parseInt("100");
int b=0;
            System.out.println("Division: " + (a / b));

            System.out.println(numbers[5]);

        }catch (ArithmeticException e)
        {
 System.out.println("Airthmentic exciprion"+e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException"+e.getMessage());
        }catch (NumberFormatException e)
        {
            System.out.println("Arthmentic exceprion"+e.getMessage());
        }
        System.out.println("Program exceuctes succeffuly");
    }
}
