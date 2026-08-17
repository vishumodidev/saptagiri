package basics;

import java.util.Scanner;
public class FindMax {
    public static void main(String[] args)
    {
        int a=25;
        int b=50;
        int c=60;

        int maximum =a;
        if(b>maximum)
        {
            maximum=b;
        }
        if(c > maximum)
        {
            maximum=c;
        }
        System.out.println("The maiximum of all "+ maximum);
    }
}
