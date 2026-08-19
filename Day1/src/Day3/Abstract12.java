
package Day3;

abstract class Vehicle123 {
    abstract void start();
    void stop(){System.out.println("Vehicle stopped");}
}
class Car extends Vehicle123 {
    void start(){System.out.println("Car starts");}
}
public class Abstract12 {
    public static void main(String[] args){
        Car c=new Car();
        c.start();c.stop();}
}
