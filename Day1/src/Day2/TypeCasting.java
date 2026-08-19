package Day2;

public class TypeCasting {
    public static void main(String[] args)
    {
        int number=100;

        double value=number;
        System.out.println(value);
        double price = 99.99;
        System.out.println("The Round off"+Math.round(price));

        int converted = (int) price;    // narrowing: double -> int

        System.out.println(converted);  // 99 (fraction is TRUNCATED, not rounded)

    }
}
