package Day2;

public class OperatorPrecedence {
    public static void  main( String[] args)
    {
        int result = 10 + 5 * 2;

        System.out.println(result);       // 20, NOT 30

        int result2 = (10 + 5) * 2;

        System.out.println(result2);      // 30

    }
}
