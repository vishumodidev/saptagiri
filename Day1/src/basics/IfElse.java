package basics;

public class IfElse {

    public static void main(String[] args)
    {
        String id1="ADHAR";
        String id2="PAN";


        if(id1 == "ADHAR")
        {
            System.out.println("Yes Allowed");
        }
        else if(id2 == "LC")
        {
            System.out.println("Yes allowed");
        }
        else
        {
            System.out.println("Sorry not allowed nither dont have "+id1+ " or" +id2);
        }
    }
}
