package basics;

public class LogicalOperators {

    public static void main(String[] args)
    {
        int age=21;

        boolean student=true;

        System.out.println(age>=20 && student);
        System.out.println(age != 11 && !student);
        System.out.println(age>=20 && student );
    }
}
