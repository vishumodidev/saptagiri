package Day3;

public class Stud {

    String name;
    Stud(String name) {this.name=name;}
    void display(){System.out.println("The STudent Name is" +this.name);}

    public static void main(String[] args)
    {
      new Stud("Hari").display();
    }

}
