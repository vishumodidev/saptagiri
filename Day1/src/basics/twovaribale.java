package basics;

public class twovaribale {

    public static class DataTypes{
        public void printVariable()
        {
            int age=25;
            System.out.println("By Calling COsntructure"+age);
        }
    }

public  void main(String[] args)
{
int age=21;
double salary=300000;
char grade='A';
boolean placed = false;
String name="rahul";
System.out.println(age);
System.out.println(grade);
    System.out.println(placed);
    System.out.println(name);
    System.out.println(salary);
    DataTypes dat=new DataTypes();
    dat.printVariable();
}
}
