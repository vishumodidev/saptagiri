package Day3;

public class Animal {

    void eat()
    {
        System.out.println("Dog Eats");
    }
    static class Dog extends Animal
    {
        void bark()
        {
            System.out.println("Dog Barks");
        }
    }


    static class Cat extends  Dog
    {
        void jump()
        {
            System.out.println(" cat JUmps");
        }
    }
        public static void main(String[] args) {
//            Dog d=new Dog(); d.eat(); d.bark(); }
            Cat c = new Cat();
            c.eat();
            c.bark();
            c.jump();

        }
}
